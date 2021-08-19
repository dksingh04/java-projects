package com.dk.dp;

import java.io.*;
import java.util.*;

public class TargetSumTabularDP {

    public static class Pair {
        int i;
        int j;
        String psf;

        public Pair(int i, int j, String psf) {
            this.i = i;
            this.j = j;
            this.psf = psf;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int tar = Integer.parseInt(br.readLine());

        //write your code here

        boolean dp[][] = new boolean[n + 1][tar + 1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = false;
                } else {
                    if (dp[i - 1][j]) {
                        dp[i][j] = true;
                    } else if (j >= arr[i - 1]) {
                        if (dp[i - 1][j - arr[i - 1]]) {
                            dp[i][j] = true;
                        }
                    }
                }

            }
        }

        System.out.println(dp[n][tar]);

        ArrayDeque<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(n, tar, ""));

        while (!queue.isEmpty()) {
            Pair rem = queue.removeFirst();
            if (rem.i == 0 || rem.j == 0) {
                System.out.println(rem.psf);
            } else {
                if (rem.j >= arr[rem.i - 1]) {
                    boolean incl = dp[rem.i - 1][rem.j - arr[rem.i - 1]];
                    if (incl) {
                        queue.add(new Pair(rem.i - 1, rem.j - arr[rem.i - 1], rem.i - 1 + " " + rem.psf));
                    }
                }
                boolean excl = dp[rem.i - 1][rem.j];
                if (excl) {
                    queue.add(new Pair(rem.i - 1, rem.j, rem.psf));
                }
            }
        }

    }
}