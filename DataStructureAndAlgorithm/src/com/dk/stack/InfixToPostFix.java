package com.dk.stack;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class InfixToPostFix {
    private static Map<Character, Integer> prece = new HashMap<>();
    //TODO build prefix, infix, postfix evaluation tree.
    public static void main(String ...args){
        prece.put('*', 3);
        prece.put('/', 3);
        prece.put('+', 2);
        prece.put('-', 2);
        prece.put('(', 1);

        System.out.println(infixToPostFix("A*B+C*D"));
        System.out.println(evaluateExpression(infixToPostFix("6+4/2*2")));

    }

    public static String infixToPostFix(String infixExpr){
        StringBuilder postfix = new StringBuilder();
        Stack<Character> operatorsStack = new Stack<>();
        for(int i = 0; i < infixExpr.length(); i++){
            if((infixExpr.charAt(i) >= 'A' && infixExpr.charAt(i) <= 'Z')
                    || (infixExpr.charAt(i) >= '0' && infixExpr.charAt(i) <= '9')){
                postfix.append(infixExpr.charAt(i));
            }else if(infixExpr.charAt(i) == '('){
                operatorsStack.push('(');
            }else if(infixExpr.charAt(i) == ')'){
                Character token = operatorsStack.pop();
                while(token != '('){
                    postfix.append(token);
                    token = operatorsStack.pop();
                }
            }else{
                while(!operatorsStack.isEmpty() &&
                        (prece.get(operatorsStack.peek())
                                >= prece.get(infixExpr.charAt(i)))){
                    postfix.append(operatorsStack.pop());
                }
                operatorsStack.push(infixExpr.charAt(i));
            }
        }

        while(!operatorsStack.isEmpty()){
            postfix.append(operatorsStack.pop());
        }

        return postfix.toString();
    }

    public static int evaluateExpression(String postfix){
        Stack<Integer> result = new Stack<>();
        //postfix expression should contains Mathematical expression
        for(int i = 0; i < postfix.length(); i++){
            if(postfix.charAt(i) >= '0' && postfix.charAt(i) <= '9'){
                result.push(Character.getNumericValue(postfix.charAt(i)));
            }else{
                Integer res = doMathOp(postfix.charAt(i),result.pop(), result.pop());
                result.push(res);
            }
        }
        return result.pop();
    }

    private static Integer doMathOp(Character op, Integer op2, Integer op1){
        switch (op) {
            case '*': return op1 * op2;
            case '+': return op1 + op2;
            case '-': return op1 - op2;
            case '/': return op1 / op2;
        }
        return 0;
    }
}
