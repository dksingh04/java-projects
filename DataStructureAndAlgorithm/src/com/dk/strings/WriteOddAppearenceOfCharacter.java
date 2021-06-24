package com.dk.strings;

public class WriteOddAppearenceOfCharacter {
    /*
    Write a function solution that, given an integer N, returns a string consisting of N lowercase letters (a−z) such that each letter occurs an odd number of times. We only care about occurrences of letters that appear at least once in the result.
    Examples:
    1. Given N = 4, the function may return "code" (each of the letters "c", "o", "d" and "e" occurs once). Other correct answers are: "cats", "uutu" or "xxxy".
    2. Given N = 7, the function may return "gwgtgww" ("g" and "w" occur three times each and "t" occurs once).
    3. Given N = 1, the function may return "z".
    Write an efficient algorithm for the following assumptions:
    N is an integer within the range [1..200,000].
 */

    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        int n = 30;
        if(n%2 == 0){
            for(int i = 0; i < n - 1; i++){
                builder.append("a");
            }
            builder.append("b");
        }else{
            for(int i = 0; i < n; i++){
                builder.append("a");
            }
        }

        System.out.println(builder.toString());
        System.out.println(builder.toString().length());
    }


}
