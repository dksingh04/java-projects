package com.dk.codeproblems;

import java.util.ArrayList;

public class MergeOverlapIntervals {
    static ArrayList<DataPair> mergeIntervals(ArrayList<DataPair> v) {
        ArrayList<DataPair> result = new ArrayList<DataPair>();
        // write your code here
        if (v == null || v.size() == 0) {
            return null;
        }

        result.add(new DataPair(v.get(0).first, v.get(0).second));

        for (int i = 1; i < v.size(); i++) {
            int x1 = v.get(i).first;
            int y1 = v.get(i).second;
            int x2 = result.get(result.size() - 1).first;
            int y2 = result.get(result.size() - 1).second;

            if (y2 >= x1) {
                result.get(result.size() - 1).second = Math.max(y1, y2);
            } else {
                result.add(new DataPair(x1, y1));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        ArrayList<DataPair> v = new ArrayList<>();

        v.add(new DataPair(1, 5));
        v.add(new DataPair(3, 7));
        v.add(new DataPair(4, 6));
        v.add(new DataPair(6, 8));
        v.add(new DataPair(10, 12));
        v.add(new DataPair(11, 15));

        ArrayList<DataPair> result = mergeIntervals(v);

        for(int i=0; i<result.size(); i++){
            System.out.print(String.format("[%d, %d] ", result.get(i).first, result.get(i).second));
        }
    }
}

class DataPair {
    public int first;
    public int second;

    public DataPair(int x, int y){
        this.first = x;
        this.second = y;
    }
}