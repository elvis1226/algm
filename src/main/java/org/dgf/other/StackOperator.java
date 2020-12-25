package org.dgf.other;

import java.util.Stack;

public class StackOperator {
    //2 + 10 * 3 / 1 - (2 + 10-2) *2

    public static int apply(int a, int b, char ops) {
        switch (ops) {
            case '+' : return a+b;
            case '-' : return a-b;
            case '*' : return a*b;
            case '/' : return a/b;
        }
        return 0;
    }

    public static boolean isLowerPriority(char a, char b) {
        if (a == '+' && b == '*') return true;
        if (a == '+' && b == '/') return true;
        if (a == '+' && b == '-') return true;
        if (a == '-' && b == '+') return true;
        if (a == '-' && b == '/') return true;
        if (a == '-' && b == '*') return true;
        if (a == '/' && b == '*') return true;
        if (a == '*' && b == '/') return true;
        return false;
    }

    public static int calculate(String expression) {
        Stack<Integer> parameter = new Stack<>();
        Stack<Character> operator = new Stack<>();

        for (int i = 0; i < expression.length(); i++){
            char c = expression.charAt(i);
            if (Character.isDigit(c)) {
                String temp = c+"";
                while ((i+1)< expression.length() && Character.isDigit(expression.charAt(i+1))) {
                    temp += expression.charAt(i+1);
                    i++;
                }

                parameter.push(Integer.parseInt(temp));

            }
            else {
                char ops = 'N';
                while (!operator.isEmpty() && isLowerPriority(c, operator.peek())) {
                    ops = operator.pop();
                    int a = parameter.pop();
                    int b = parameter.pop();
                    int r = apply(b,a,ops);
                    parameter.push(r);
                }

                if (c == ')') {
                     while (!operator.isEmpty() && operator.peek() != '('){
                        ops = operator.pop();
                        int a = parameter.pop();
                        int b = parameter.pop();
                        int r = apply(b,a,ops);
                        parameter.push(r);
                    }
                    operator.pop();
                    continue;
                }
                operator.push(c);
            }
        }

        while (!operator.isEmpty()) {
            char ops = operator.pop();
            int a = parameter.pop();
            int b = parameter.pop();
            int r = apply(b,a,ops);
            parameter.push(r);
        }

        System.out.println("size : "+ parameter.size());
        return parameter.pop();
    }

    public static void main(String[] argv) {
        String param1 = "2+10*3/1-(2+1-2)*2";
        int result1 = calculate(param1);
        System.out.println(param1 +" = " + result1);

        String param2 = "2+10*3/3-2+1-4*2";
        int result2 = calculate(param2);
        System.out.println(param2 +" = " + result2);

    }

}
