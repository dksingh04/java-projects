package com.dk.codeproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeOverlaps {
    public static void main(String ...args){
        merge(new int[][]{{2,3},{4,5},{6,7},{8,9},{1,10}});
    }
    public static int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length == 0){
            return null;
        }
        List<int[]> merged = new ArrayList<>();
        Arrays.sort(intervals , (a , b) -> a[0]-b[0]);

        merged.add(intervals[0]);

        for(int i = 1; i < intervals.length; i++){
            int [] curr = intervals[i];
            int [] prev = merged.remove(merged.size() - 1);

            if(prev[1] >= curr[0]){
                merged.add(new int[]{prev[0], Math.max(prev[1], curr[1])});

            }else{
                merged.add(prev);
                merged.add(curr);
            }
        }

        int finalRes [][] = new int[merged.size()][2];

        for(int i = 0; i < merged.size(); i++){
            finalRes[i] = merged.get(i);
            finalRes[i] = merged.get(i);
        }

        return finalRes;

    }


}
