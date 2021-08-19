package com.dk.stack;

import java.util.HashMap;
import java.util.Map;

public class TestCharComparison {
    public static void main(String ...args){
        String charSet ="+-/*";

        for(int i = 0; i < charSet.length(); i++){
            System.out.print(charSet.charAt(i)+": ");
            System.out.println(charSet.charAt(i) == '*');
        }
    }
}
