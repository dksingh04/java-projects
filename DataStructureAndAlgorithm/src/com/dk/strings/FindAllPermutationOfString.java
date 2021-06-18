package com.dk.strings;

import java.util.ArrayList;
import java.util.List;

public class FindAllPermutationOfString {

    public static void main(String ...args){
        List<String> result = findAllPermutations("bad");
        /* bad -> bad --> fix b bad
                  swap(ad)  -> da -> bda
           swap(ba) abd -> fix a -> abd
                       swap(bd) -> adb
           swap(ad) dab -> fix d -> dab
                           swap(ab) -> dba

         */

        result.stream().forEach(System.out::println);
    }

    public static void permutations(char[] input, List<String> result, int currentIndex){

        if(currentIndex == input.length-1){
            String s = new String(input);
            result.add(s);
            return;
        }

        for(int i = currentIndex; i < input.length; i++){
            swapChars(input, currentIndex, i);
            permutations(input, result, currentIndex+1);
            swapChars(input, currentIndex, i);
        }

    }

    public static List<String> findAllPermutations(String input){
        List<String> result = new ArrayList<>();
         permutations(input.toCharArray(), result, 0);
        return result;
    }

    private static void swapChars(char [] input, int i, int j){
        char temp = input[i];
        input[i] = input[j];
        input[j] = temp;

    }
}
