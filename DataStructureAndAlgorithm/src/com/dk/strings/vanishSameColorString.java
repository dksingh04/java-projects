package com.dk.strings;

public class vanishSameColorString {
    /*
      Given N number of balls of different colors kept in a straight line, if the color of two balls is same they collide together and vanish. Write a program to find the number of such collisions and the leftover number of balls?
        Input: azxxzy
        Output: ay
        Input: abccbxyyxba
        Output: aba
     */

    public static void main(String ...args){
        System.out.println(vanishSameAdjacentString("azxxxzzzzyyyyya".toCharArray()));
        System.out.println(vanishSameAdjacentString("abccbxyyxba".toCharArray()));
    }

    public static String vanishSameAdjacentString(char [] chars){
        int writeIndex = 0;
        int readIndex = 1;
        int len = chars.length - 1;
        while(readIndex <= len){
            if(chars[writeIndex] != chars[readIndex]){
                chars[writeIndex + 1] = chars[readIndex];
                writeIndex++;
                readIndex++;
            }else{
                while(readIndex <= len && chars[writeIndex] == chars[readIndex]){
                    readIndex++;
                }
                writeIndex--;
            }
        }
        chars[writeIndex + 1] = '\0';
        StringBuilder builder =  new StringBuilder();
        int i = 0;
        while(i <= writeIndex){
            builder.append(chars[i]);
            i++;
        }
        return builder.toString();
    }
}
