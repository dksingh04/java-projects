package com.dk.array;

public class SearchIn2DMatrix {
    public static void main(String ...args){
        System.out.println(searchMatrix(new int[][]{
                {1,4,7,11,15},
                {2,5,8,12,19},
                {3,6,9,16,22},
                {10,13,14,17,24},
                {18,21,23,26,30}}, 0));


        System.out.println(searchMatrix(new int[][]{
                {-1, 3}}, 3));

        System.out.println(searchMatrix(new int[][]{
                {1,6,10,13,14,16,21},
                {3,10,12,18,22,27,29},
                {3,15,19,20,23,29,34},
                {8,15,19,25,27,29,39},
                {12,17,24,25,28,29,41},
                {16,22,27,31,31,33,44},
                {20,26,28,35,39,41,45},
                {25,31,34,39,44,45,47}
        }, 38));
    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        boolean [][] seen = new boolean[matrix.length][matrix[0].length];
        return searchMatrix(matrix, target, 0, 0, seen);
    }

    public static boolean searchMatrix(int[][] matrix, int target, int r, int c, boolean [][] seen){
       /* if(r < 0 || r >= matrix.length || c < 0 || c >= matrix[0].length){
            return false;
        }
        */
        seen[r][c] = true;
        if(matrix[r][c] == target){
            return true;
        }

        if(!seen[r][c]){
            if(r < matrix.length - 1
                    && matrix[r][c] > target && searchMatrix(matrix, target, r+1, 0, seen)){
                return true;
            }else{
                if(c < matrix[0].length - 1 && searchMatrix(matrix, target, r, c + 1, seen)){
                    return true;
                }else if(r < matrix.length - 1 && searchMatrix(matrix, target, r+1, 0, seen)){
                    return true;
                }
            }
        }
        return false;
    }
}
