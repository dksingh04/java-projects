package com.dk.codeproblems;

public class FindAllPalendromeOfString {


    public static int findAllPalindromeSubstrings(String input, int left, int right){
        int count = 0;
        for(; left>=0 && right < input.length(); --left, ++right){
            if(input.charAt(left) != input.charAt(right)){
                break;
            }
            count++;
            System.out.println(input.substring(left, right+1));
        }
        return count;
    }
    public static int findAllPalindromeSubstrings(String input){
        int count = 0;
        if(input.isEmpty() || input.length() == 1){
            return count;
        }

        for(int i = 0; i < input.length(); i++){
            count += findAllPalindromeSubstrings(input, i-1, i+1);
            count += findAllPalindromeSubstrings(input, i, i+1);
        }

        return count;
    }
    public static void main(String[] args) {
        String str = "aabbbaa";
        int count = findAllPalindromeSubstrings(str);
        System.out.println("Total palindrome substrings: " + count);
    }
}
