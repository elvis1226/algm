import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: Du Gangfeng
 * Date: 8/10/15
 * Time: 13:06 PM
 */


public class Spreadsheet {
    private Cell[][] cells;
    public long actualCount = 0;
    public final int rows;        //A, B, C, ... Z
    public final int columns;     //1, 2, 3, ... N

    public Spreadsheet(int rows, int columns){
        this.rows    = rows;
        this.columns = columns;
        this.cells   = new Cell[rows][columns];
    }

    public Cell get(int rowIndex, int columnIndex) {
        return this.cells[rowIndex][columnIndex];
    }

    public boolean exist(int rowIndex, int columnIndex) {
        return this.cells[rowIndex][columnIndex] == null ? false : true;
    }

    public void insert(int rowIndex, int columnIndex, String expression){
        Cell cell = new Cell(""+rowIndex+columnIndex, expression);
        this.cells[rowIndex][columnIndex] = cell;
        cell.init();
    }

    public void print(){
        System.out.println(this.columns + " " + this.rows);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                System.out.println(String.format("%.5f", this.cells[i][j].getValue()));
            }
        }
    }

     class Cell{
        private String  name;
        private double  value;
        private boolean active = false;

        public List<Cell> dependOn;
        public String     expression;
        public List<Cell> notified;


        public Cell(String name, String expression) {
            this.name       = name;
            this.expression = expression;
        }

        public void init(){

            String[] exps = this.expression.split(" ");

            if (exps.length == 1){
                char rowLabel = exps[0].charAt(0);

                if (!isAToZ(rowLabel)){
                    double val = Double.parseDouble(exps[0]);
                    this.setValue(val);
                    this.notified();
                }
                else {
                    this.checkReference(exps[0]);
                }
            }
            else {
                for (String s : exps){
                    if (!this.isOperator(s) ) {
                        if (isAToZ(s.charAt(0)))  {
                            this.checkReference(s);
                        }
                    }
                }
            }

            if (!this.active){
                if (this.dependOn == null || this.dependOn.isEmpty()) {
                    this.evaluate();
                }
            }
        }


        public double getValue() {
            return value;
        }

        public void setValue(double value) {
            this.value = value;
            this.active = true;
            actualCount++;
        }

        public void setExpression(String expression) {
            this.expression = expression;
        }

        public void addDepends(Cell... cells){
            if (this.dependOn == null) {
                this.dependOn = new ArrayList<Cell>();
            }
            for (Cell c : cells) {
                this.dependOn.add(c);
            }
        }

        public void addNotified(Cell... cells){
            if (this.notified == null) {
                this.notified = new ArrayList<Cell>();
            }
            for (Cell c : cells) {
                this.notified.add(c);
            }
        }

         private void checkReference(String label)
         {
             int r = label.charAt(0) - 'A';
             int c = Integer.parseInt(label.substring(1)) - 1;

             Cell n = cells[r][c];
             if (n == null) {
                 n = new Cell(""+r+c, "");
                 cells[r][c] = n;
             }
             else {
                 if (n.active){
                     return;
                 }
             }
             this.addDepends(n);
             n.addNotified(this);
         }

         private boolean isAToZ(char ch){
             if (ch >= 'A' && ch <= 'Z') {
                 return true;
             }

             return false;
         }

        private void notified(){
            if (this.notified == null) {
                return;
            }
            for (Cell c : this.notified) {
                c.fire(this);
            }
        }

        private void fire(Cell cell){
            if(!this.dependOn.contains(cell))  {
                System.out.println("error when fire") ;
            }
            this.dependOn.remove(cell);
            if (this.dependOn.isEmpty()) {
                this.evaluate();

            }
        }

        private double getValueByLabel(String label){
            int rowIndex    = label.charAt(0) - 'A';
            int columnIndex = Integer.parseInt(label.substring(1)) - 1;
            return cells[rowIndex][columnIndex].getValue();
        }

        private boolean isOperator(String ops){
            if (ops.equals("+") || ops.equals("-") || ops.equals("*") || ops.equals("/")
                    ||ops.equals("++")||ops.equals("--")) {
                return true;
            }

            return false;
        }

        private void evaluate(){
            Stack<Double> stack = null;

            String[] exps = this.expression.split(" ");
            if (exps.length == 1){
                double val = this.getValueByLabel(exps[0]);
                this.setValue(val);
            }
            else {
                stack = new Stack<Double>();
                for (String s : exps){
                    if (!isOperator(s)) {
                        if (isAToZ(s.charAt(0))) {
                            double val = this.getValueByLabel(s);
                            stack.push(val);
                        }
                        else {
                            double val = Double.parseDouble(s);
                            stack.push(val);
                        }
                    }
                    else {
                        if (s.equals("++") ||s.equals("--")){
                            double val = stack.pop();
                            if (s.equals("++")) { val++;}
                            else if (s.equals("--")) { val--;}
                            stack.push(val);
                        }
                        else {
                            double param1 = stack.pop();
                            double param2 = stack.pop();
                            double result = this.calculate(s.charAt(0), param2, param1);
                            stack.push(result);
                        }
                    }
                }

                double value = stack.pop();
                this.setValue(value);
            }
            this.notified();
        }

        private double calculate(char operator, double param1, double param2){

            switch (operator) {
                case '+': return (param1 + param2);
                case '-': return (param1 - param2);
                case '*': return (param1 * param2);
                case '/': return (param1 / param2);

                default:
                    return 0.0;
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (! (o instanceof Cell)) return false;

            Cell cell = (Cell) o;

            if (!name.equals(cell.name))
                return false;

            if (!expression.equals(cell.expression))
                return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = 17;
            result = 31 * result + name.hashCode();
            result = 31 * result + expression.hashCode();
            return result;
        }
    }


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int width  = in.nextInt();
        int height = in.nextInt();
        in.nextLine();

        long totalNum = width * height;
        Spreadsheet spreadSheet = new Spreadsheet(height, width);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                String line = in.nextLine();

                if (!spreadSheet.exist(i, j)) {

                    spreadSheet.insert(i, j, line);
                }
                else {
                    spreadSheet.get(i, j).setExpression(line);
                    spreadSheet.get(i, j).init();
                }
            }
        }

        if (spreadSheet.actualCount != totalNum){
            System.exit(1);
        }

        spreadSheet.print();
    }

}
