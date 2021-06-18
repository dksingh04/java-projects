package com.dk.strings;

public class ReverseWordCharsInPlace {
    /*
      Reverse the given sentence word in place, the sentence might contains some special characters and those
      special character position should not change.
        // "Hello my.name is Richard."
        // "olleH ym.eman si drahciR."
        // ..!
     */

    public static void main(String ...args){
        System.out.println(reverseWords("\"Hello my.name! is Richard.\""));
        System.out.println(reverseWords("..!"));
    }
    public static boolean isWordCharacter(char ch){
        String s = " '\"!~`.,";
        return s.indexOf(ch) == -1;
    }
    public static String reverseWords(String str){
        int start = 0;
        int end;
        int len = str.length() - 1;
        char [] sentence = str.toCharArray();
        System.out.println(sentence);
        while(start < len){
            while(start < len && !isWordCharacter(sentence[start])){
                start++;
            }
            end = start + 1;

            while(end < len && isWordCharacter(sentence[end])){
                end++;
            }

            reverseChar(sentence, start, end - 1);
            start = end;
        }

        String s = new String(sentence);

        return s;

    }


    public static void reverseChar(char [] input, int start, int end){
        while(start < end){
            char temp = input[start];
            input[start] = input[end];
            input[end] = temp;
            start++;
            end--;
        }


    }
}
