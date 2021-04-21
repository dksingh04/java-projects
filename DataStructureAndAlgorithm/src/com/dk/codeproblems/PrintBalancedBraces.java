package com.dk.codeproblems;

public class PrintBalancedBraces {
    public static void main(String ...args){
        StringBuilder sb = new StringBuilder();
        buildBraces(3, sb);
        System.out.println(sb);
    }


    public static void buildBraces(int N, StringBuilder sb){
        if(N == 0){
            return;
        }
        if(N == 1){
            sb.append("{}");
        }

        for(int i = 1; i <= N*2; i++){
            if(i <= N){
                sb.append("{");
            }
            if(i > N){
                sb.append("}");
            }
        }
        sb.append(" ");
        for(int i = N-1; i>= 1; i--){
            buildBraces(i, sb);
        }

    }

}
