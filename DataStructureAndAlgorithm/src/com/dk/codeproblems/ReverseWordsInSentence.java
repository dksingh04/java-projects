package com.dk.codeproblems;

public class ReverseWordsInSentence {

    public static void strRev(char[] str, int start, int end){
        if(str == null || str.length < 2){
            return;
        }

        while(start < end){
            char temp = str[start];
            str[start] = str[end];
            str[end] = temp;
            start++;
            end--;
        }
    }

    public static void reverseWords(char [] sentence){
        //Reverse complete String
        int len = sentence.length -1;
        strRev(sentence, 0, len);
        System.out.println(sentence);
        //Now reverese each word in place.
        int start = 0;
        int end;

        while(start < len){
            while(sentence[start] == ' '){
                ++start;
            }
            if (start >= len ) {
                break;
            }

            end = start + 1;
            while(end <= len && sentence[end] != ' '){
                ++end;
            }
            strRev(sentence, start, end-1);
            start = end;
        }

    }

    public static void main(String[] args) {
        char[] s = "You are amazing".toCharArray();
        System.out.println(s);
        System.out.println(s.length);
        reverseWords(s);
        System.out.println(s);
    }
}
