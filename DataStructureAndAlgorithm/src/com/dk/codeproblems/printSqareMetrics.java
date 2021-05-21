package com.dk.codeproblems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class printSqareMetrics {
    /**
     *
     * If given number is odd then output should be
     * for e.g. In: 5
     * Op:
     * x000x
     * 0x0x0
     * 00X00
     * 0x0x0
     * x000x
     * And if it is even then output should be like below.
     * For e.g. In: 6
     * Op:
     * xxxxxxxx
     * x000000x
     * x000000x
     * x000000x
     * x000000x
     * x000000x
     * x000000x
     * xxxxxxxx
     */

    public static void main(String ...args){
        printSqareMetrics(5);
        System.out.println();
        System.out.println("**********************************************");
        System.out.println();
        printSqareMetrics(6);
    }

    public static void printSqareMetrics(int num){
        List<String> result = new ArrayList<>();
        int i = 0;
        int j = num - 1;
        StringBuilder builder = new StringBuilder();
        if(num % 2 != 0){
            Stack<String> stack = new Stack<>();
            int noOftimes = num/2;
            for(int k = 0; k < num; k++){
                builder = builder.append("0");
            }
            String str = builder.toString();
            while(noOftimes >= 0){
                if(i == j){
                    builder = builder.replace(i, i+1,"x");
                }else{
                    builder = builder.replace(i, i+1,"x");
                    builder = builder.replace(j, j+1,"x");
                    stack.push(builder.toString());
                }
                result.add(builder.toString());
                builder.setLength(0);
                builder.append(str);
                i++;
                j--;
                noOftimes--;
            }

            while(!stack.empty()){
                result.add(stack.pop());
            }
        }else{
            StringBuilder builder2 = new StringBuilder();
            for(int k = 0; k < num; k++){
                builder = builder.append("x");
                if(k == i || k == j){
                    builder2 = builder2.append("x");
                }else{
                    builder2 = builder2.append("0");
                }
            }
            String fnLastRow = builder.toString();
            String otherRow = builder2.toString();

            result.add(fnLastRow);
            for(int l = 1; l < num-1; l++){
                result.add(otherRow);
            }
            result.add(fnLastRow);
        }

        result.forEach(System.out::println);

    }
}
