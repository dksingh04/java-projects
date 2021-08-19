package com.dk.dp;

import java.util.Scanner;

public class BiTonicSequence {
    public static void main(String[] args) throws Exception {
        // write your code here
        //https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/lbs-official/ojquestion
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int [] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int [] lis = new int[n];
        //Longest Increasing Sequence
        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (arr[j] <= arr[i]) {
                    if (lis[j] > max) {
                        max = lis[j];
                    }
                }
            }

            lis[i] = max + 1;
        }

        //Longest Decreasing Sequence
        int [] lds = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int max = 0;
            for (int j = n - 1; j > i; j--) {
                if (arr[j] <= arr[i]) {
                    if (lds[j] > max) {
                        max = lds[j];
                    }
                }
            }

            lds[i] = max + 1;
        }

        int omax = 0;
        for (int i = 0; i < n; i++) {
            if (lis[i] + lds[i] - 1 > omax) {
                omax = lis[i] + lds[i] - 1;
            }
        }

        System.out.println(omax);

    }
}
