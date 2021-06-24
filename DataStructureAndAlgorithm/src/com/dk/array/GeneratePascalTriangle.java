package com.dk.array;

import java.util.ArrayList;
import java.util.List;

public class GeneratePascalTriangle {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < numRows; i++){
            List<Integer> subResult = new ArrayList<>();
            int col = 0;
            for(int j = 0; j <= i; j++){
                if(j == 0 || j == i){
                    subResult.add(1);
                }else{
                    List<Integer> prvRow = result.get(i-1);
                    subResult.add(prvRow.get(col)+prvRow.get(col+1));
                    col++;
                }

            }
            subResult.stream().forEach(System.out::print);
            System.out.println();
            result.add(subResult);
        }

        return result;
    }

    public static void main(String ...args){
        List<List<Integer>> result = generate(5);
    }
}
