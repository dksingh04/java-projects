package com.dk.patterns;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
/*

In: 5:
Op:
        *
    *	*	*
 *	*	*	*	*
    *	*	*
        *
 */
public class PrintDiamondPattern {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here

        int n = scn.nextInt();
        Stack<String> stack = new Stack<>();
        List<String> result = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        for(int i = 1; i <= n; i+= 2){
            builder.append("\t".repeat((n - i)/2)).append("*\t".repeat(i)).append("\t".repeat((n -i)/2)).append("\n");
            if(i < n){
                stack.push(builder.toString());
            }
            result.add(builder.toString());
            builder.setLength(0);

        }

        //System.out.println(stack);
        while(!stack.isEmpty()){
            result.add(stack.pop());
        }


        result.stream().forEach(System.out::print);
    }
}
