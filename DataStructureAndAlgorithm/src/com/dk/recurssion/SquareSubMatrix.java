package com.dk.recurssion;

import java.util.Arrays;

public class SquareSubMatrix {

    public static void main(String ...args){
        boolean [][] matrix = {
                                {false,true,false,false},
                                {true,true,true,true},
                                {false,true,true,false}
                              };
        System.out.println(squareSubMatrix(matrix));
        System.out.println(squareSubMatrixCache(matrix));
        System.out.println(squareSubMatrixIterative(matrix));
    }

    public static int squareSubMatrix(boolean[][] arr){
        if(arr.length == 0){
            return 0;
        }
        int max = 0;

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                if(arr[i][j]){
                    max = Math.max(max, squareSubMatrix(arr, i, j));
                }
            }
        }

        return max;
    }

    private static int squareSubMatrix(boolean [][]arr, int i, int j){
        if( i == arr.length || j == arr[0].length){
            return 0;
        }
        if(!arr[i][j]) return 0;

        return 1 + Math.min(Math.min(squareSubMatrix(arr, i, j + 1),
                        squareSubMatrix(arr, i + 1, j)), squareSubMatrix(arr, i+1, j+1));
    }


    private static int squareSubMatrixCache(boolean [][] arr){
        int [][] cache =  new int[arr.length][arr[0].length];
        int max  = 0;
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                if(arr[i][j]){
                    max = Math.max(max, squareSubMatrixCache(arr, i, j, cache));
                }
            }
        }

        return max;
    }

    private static int squareSubMatrixCache(boolean [][]arr, int i, int j, int[][] cache){
        if(i == arr.length || j == arr[0].length){
            return 0;
        }
        if(!arr[i][j]){
            return 0;
        }
        //return cached value
        if(cache[i][j] > 0 ){
            return cache[i][j];
        }

        cache[i][j] = 1 + Math.min(Math.min(squareSubMatrixCache(arr, i, j + 1, cache),
                        squareSubMatrixCache(arr, i + 1, j, cache)), squareSubMatrixCache(arr, i + 1, j + 1, cache));

        return cache[i][j];

    }

    private static int squareSubMatrixIterative(boolean [][]arr){
        int [][] cache = new int[arr.length][arr[0].length];
        int max = 0;
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                if(i == 0 || j == 0){
                    cache[i][j] = arr[i][j]?1:0;
                }else if(arr[i][j]){
                    cache[i][j] = Math.min(Math.min(cache[i][j-1], cache[i-1][j]),cache[i-1][j-1])+1;
                }

                if(cache[i][j] > max){
                    max = cache[i][j];
                }
            }
        }
        Arrays.stream(cache).forEach(v -> {
            System.out.println();
            Arrays.stream(v).forEach(System.out::print);
        });
        System.out.println();
        return max;
    }
}
