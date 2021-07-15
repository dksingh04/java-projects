package com.dk.strings;

import java.util.*;

public class CustomSortString {

    public static void main(String ...args){
        System.out.println(customSortString("kqep","pekeq"));
        System.out.println(customSortStringOptimized("kqep","pekeq"));
    }
    public static String customSortString(String order, String str) {
        Map<Character, Integer> orderPriority = new HashMap<>();
        for(int i = 0;  i < order.length(); i++){
            orderPriority.put(order.charAt(i), i);
        }
        PriorityQueue<CharPriority> queue = new PriorityQueue<>(Comparator.comparing(CharPriority::getPriority));
        for(int j = 0; j < str.length(); j++){
            queue.add(new CharPriority(str.charAt(j), orderPriority.getOrDefault(str.charAt(j), -1)));
        }
        //Collections.sort(queue, Comparator.comparing(CharPriority::getPriority));
        char [] res = new char[queue.size()];
        int i = 0;
        while(!queue.isEmpty()){
            res[i++] = queue.poll().getCh();
        }

        return new String(res);
    }

    public static String customSortStringOptimized(String order, String str) {
        int [] arr = new int[26];
        for(int i = 0; i < str.length(); i++){
            arr[str.charAt(i) - 'a']++;
        }
        StringBuilder builder = new StringBuilder();
        for(int j = 0; j < order.length();  j++){
            while(arr[order.charAt(j) - 'a']-- > 0){
                builder.append(order.charAt(j));
            }
        }

        for(int i = 0; i < 26; i++){
            while(arr[i]-- > 0){
                builder.append((char)(i + 'a'));
            }

        }

        return builder.toString();
    }
}

class CharPriority{
    private char ch;
    private Integer priority;

    public CharPriority(char ch, Integer priority){
        this.ch = ch;
        this.priority = priority;
    }

    public Integer getPriority(){
        return this.priority;
    }
    public char getCh(){
        return this.ch;
    }
}
