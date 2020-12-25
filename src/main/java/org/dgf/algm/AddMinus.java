package org.dgf.algm;

import java.util.*;

/*
Your previous Markdown content is preserved below:


You are building an educational website and want to create a simple calculator for students to use. The calculator will only allow addition and subtraction of positive integers.

Given an expression string using the "+" and "-" operators like "5+16-2", write a function to find the total.


Sample input/output:
evaluate("6+9-12")  => 3
evaluate("1+2-3+4-5+6-7") => -2

 */

class AddMinus {

    public static int evaluate(String val){
        int result = 0;
        Deque<Character> opsStack = new ArrayDeque<Character>();
        Deque<String> paramStack = new ArrayDeque<String>();

        for (int i = 0; i< val.length(); i++) {
            char c = val.charAt(i);
            if ( c == '+' || c == '-') {
                opsStack.add(c);
            }
            else {
                String v = ""+c;
                while ((i+1)< val.length()) {
                    char next = val.charAt(i+1);
                    if (next !='+' && next !='-'){
                        v += next;
                        i++;
                    }
                    else {

                        break;
                    }
                }

                paramStack.add(v);
            }
        }
        result=Integer.parseInt(paramStack.poll());
        while (!opsStack.isEmpty()){
            char ops = opsStack.poll();
            int p1 = Integer.parseInt(paramStack.poll());
            if (ops == '+') {
                result += (p1);
            }
            else {
                result -= (p1);
            }
        }
        return result;

    }

    public static void main(String[] args) {

        String expression1 = "6+9-12"; // = 3
        String expression2 = "1+2-3+4-5+6-7"; // = -2

        int expVal1 = evaluate(expression1);
        int expVal2 = evaluate(expression2);

        System.out.println("Expexted 3 " + expVal1);
        System.out.println("Expexted -2 " + expVal2);
    }
}



