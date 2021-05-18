package com.dk.codeproblems;

class RemoveSpaces{
    static void removeWhiteSpaces (char[] s) {
        if(s == null || s.length == 0 || s[0] == '\0'){
            return;
        }

        int readIndex = 0;
        int writeIndex = 0;
        while(readIndex < s.length){
            if(!isWhiteChar(s[readIndex])){
                s[writeIndex] = s[readIndex];
                writeIndex++;
            }
            readIndex++;
        }

        s[writeIndex] = '\0';

    }

    static boolean isWhiteChar(char ch){
        if(ch == ' ' || ch == '\t'){
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        char[] s = "All greek to me".toCharArray();
        System.out.print("Before: ");
        System.out.println(s);
        removeWhiteSpaces(s);
        System.out.print("After: ");
        System.out.println(s);
    }
}