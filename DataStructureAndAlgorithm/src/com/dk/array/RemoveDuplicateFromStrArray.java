package com.dk.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicateFromStrArray{

    public static void removeDuplicates(char[] str){
        int writeIndex = 0;
        int readIndex = 0;
        Set<Character> s = new HashSet<>();
        while(readIndex != str.length){
            if(!s.contains(str[readIndex])){
                s.add(str[readIndex]);
                str[writeIndex] = str[readIndex];
                writeIndex++;
            }
            readIndex++;
        }

        str[writeIndex] = '\0';
    }

    public static void main(String[] args) {

        char[] input = "dabbac".toCharArray();
        System.out.print("Before: ");
        System.out.println(input);
        removeDuplicates(input);
        System.out.print("After: ");
        print(input);
    }

    static void print(char[] s) {
        int i = 0;
        while (s[i] != '\0') {
            System.out.print(s[i]);
            ++i;
        }
        System.out.println();
    }

}
