package com.dk.codeproblems;

import java.util.ArrayList;

class AllBraces{
    static void print(ArrayList<String> arr) {
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i).toString());
        }
    }

    static void printAllBacesRec(
            int n,
            int leftCount,
            int rightCount, ArrayList<String> output,
            ArrayList<String> result) {

        if (leftCount >= n && rightCount >=n) {
            result.add(String.join("", output));
        }

        if (leftCount < n) {
            output.add("{");
            printAllBacesRec(n, leftCount + 1, rightCount, output, result);
            output.remove(output.size() - 1);
        }

        if (rightCount < leftCount) {
            output.add("}");
            printAllBacesRec(n, leftCount, rightCount + 1, output, result);
            output.remove(output.size() - 1);
        }
    }

    static ArrayList<String> printAllBraces(int n) {
        ArrayList<String> result = new ArrayList<>();
        ArrayList<String> output = new ArrayList<>();
        printAllBacesRec(n, 0, 0, output, result);
        return result;
    }

    public static void main(String[] args) {
        ArrayList<String> result = new ArrayList<>();
        result =  printAllBraces(2);
        print (result);
    }
}