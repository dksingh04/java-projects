package com.dk.patterns;

import java.util.Scanner;
import java.util.Stack;

public class PrintPatterns2 {
    /*
      n will be odd.

         *	*	*		*	*	*
         *	*				*	*
         *						*
         *	*				*	*
         *	*	*		*	*	*

     *
     * */

    public static void main(String ...args){
        Scanner scn = new Scanner(System.in);

        int n = 5/2 + 1;//scn.nextInt();

        StringBuilder builder = new StringBuilder();
        Stack<String> st = new Stack<>();
        for(int i = n; i >= 1; i--){
            builder.append("*\t".repeat(i)).append("\t".repeat(n - (i))).append("\t".repeat(n - (i))).append("\t*".repeat(i)).append("\n");
            System.out.print(builder.toString());
            st.push(builder.toString());
            builder.setLength(0);
        }

        if(!st.isEmpty()){
            st.pop();
        }
        while(!st.isEmpty()){
            System.out.print(st.pop());
        }

    }
}
