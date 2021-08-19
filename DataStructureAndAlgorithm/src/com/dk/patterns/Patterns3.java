package com.dk.patterns;

import java.util.Scanner;

public class Patterns3 {

    public static void main(String ...args){


        /*
        Print in below pattern.
        In: 5
        *
	        *
		        *
			        *
				        *

         */

        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n = 5; //scn.nextInt();
        StringBuilder builder = new StringBuilder();
        for(int i = 1; i <= n; i++){
            builder.append("\t".repeat(i - 1)).append("*").append("\t".repeat(n - i)).append("\n");
            System.out.print(builder.toString());
            builder.setLength(0);
        }

    }
}
