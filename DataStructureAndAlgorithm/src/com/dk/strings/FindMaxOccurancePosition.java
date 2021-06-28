package com.dk.strings;

public class FindMaxOccurancePosition {

    public static void main(String ...args) {
        System.out.println(maxOccurancePosition("abbccccddddddddccccccc"));
    }

    public static int maxOccurancePosition(String str){
        if(str == null || str.length() == 0){
            return 0;
        }
        int maxOccurancePos = 0;
        int prevLen = 0;
        int start = 0;
        int end = 0;
        for(int i = 0; i < str.length() - 1; i++){
            if(str.charAt(i) == str.charAt(i+1)){
                end++;
            }else{
                if(prevLen < end - start){
                    maxOccurancePos = start;
                    prevLen = end - start;
                }
                start = i+1;
                end = start;
            }
        }

        if(prevLen < end - start){
            maxOccurancePos = start;
        }

        return maxOccurancePos;
    }
}
