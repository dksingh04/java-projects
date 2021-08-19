package com.dk.array;

public class BattleShipCount {
        public static void main(String ...args){
            System.out.println(countBattleships(new char[][]{{'X','.','.','X'},{'.','.','.','X'},{'.','.','.','X'}}));
        }

        public static int countBattleships(char[][] board) {
            int r = board.length;
            int c = board[0].length;
            boolean [][] seen = new boolean[r][c];
            int count = 0;
            for(int i = 0; i < r; i++){
                for(int j = 0; j < c; j++){
                    if(!seen[i][j] && board[i][j] == 'X'){
                        count += dfs(board, i, j, r, c, seen);
                    }
                }
            }

            return count;
        }

        public static int dfs(char[][] board, int Cr, int Cc, int r, int c, boolean [][] seen){

            if(Cr == r || Cc == c || board[Cr][Cc] == '.'){
                return 0;
            }

            seen[Cr][Cc] = true;

            dfs(board, Cr+1, Cc, r, c, seen);
            dfs(board, Cr, Cc+1, r, c, seen);


            return 1;

        }

}
