package com.example.user.supercalc;

/**
 * Created by User on 20.10.2015.
 */
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Scanner;

/**
 * Created by User on 14.10.2015.
 */

public class Calc {

    final public static int lp    = 0;
    final public static int rp    = 1;

    final public static int plus  = 2;
    final public static int minus = 3;

    final public static int mult  = 4;
    final public static int div   = 5;

    final public static int num   = 6;

    private static String cleanExpr(String expr){
        //remove all non-operators, non-whitespace, and non digit chars
        return expr.replaceAll("[^\\^\\*\\+\\-\\d/\\s]", "");
    }

    public static double calcRPN(String expr){
        String cleanExpr = cleanExpr(expr);
        LinkedList<Double> stack = new LinkedList<Double>();

        for(String token:cleanExpr.split("\\s")){
            System.out.print(token+"\t");
            Double tokenNum = null;
            try{
                tokenNum = Double.parseDouble(token);
            }catch(NumberFormatException e){}
            if(tokenNum != null){

                stack.push(Double.parseDouble(token+""));
            }else if(token.equals("*")){

                double secondOperand = stack.pop();
                double firstOperand = stack.pop();
                stack.push(firstOperand * secondOperand);
            }else if(token.equals("/")){

                double secondOperand = stack.pop();
                double firstOperand = stack.pop();
                stack.push(firstOperand / secondOperand);
            }else if(token.equals("-")){

                double secondOperand = stack.pop();
                double firstOperand = stack.pop();
                stack.push(firstOperand - secondOperand);
            }else if(token.equals("+")){

                double secondOperand = stack.pop();
                double firstOperand = stack.pop();
                stack.push(firstOperand + secondOperand);
            }else if(token.equals("^")){

                double secondOperand = stack.pop();
                double firstOperand = stack.pop();
                stack.push(Math.pow(firstOperand, secondOperand));
            }else{
                return 0;
            }
            System.out.println(stack);
        }
        return stack.pop();
    }
    static String infixToPostfix(String infix) {
        final String ops = "-+/*^";
        StringBuilder sb = new StringBuilder();
        Stack<Integer> s = new Stack<>();

        for (String token : infix.split("\\s")) {
            if (token.isEmpty())
                continue;
            char c = token.charAt(0);
            int idx = ops.indexOf(c);

            // check for operator
            if (idx != -1) {
                if (s.isEmpty())
                    s.push(idx);

                else {
                    while (!s.isEmpty()) {
                        int prec2 = s.peek() / 2;
                        int prec1 = idx / 2;
                        if (prec2 > prec1 || (prec2 == prec1 && c != '^'))
                            sb.append(ops.charAt(s.pop())).append(' ');
                        else break;
                    }
                    s.push(idx);
                }
            }
            else if (c == '(') {
                s.push(-2); // -2 stands for '('
            }
            else if (c == ')') {
                // until '(' on stack, pop operators.
                while (s.peek() != -2)
                    sb.append(ops.charAt(s.pop())).append(' ');
                s.pop();
            }
            else {
                sb.append(token).append(' ');
            }
        }
        while (!s.isEmpty())
            sb.append(ops.charAt(s.pop())).append(' ');
        return sb.toString();
    }
}