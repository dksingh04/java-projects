package com.dk.patterns;

import java.util.Scanner;

public class Patterns4 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here

        int n = 5;//scn.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i + j == n + 1 || i == j) {
                    System.out.print("*\t");
                } else {
                    System.out.print("\t");
                }
            }

            System.out.println();
        }

    }
}
