package com.dk.dp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CanConstructWord {
    public static void main(String ...args){
        System.out.println(canConstructWord("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"}));
        System.out.println(canConstructWord("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"}));

       /*
       // Uncomment to make the program hang
       long startTime = System.currentTimeMillis();
        System.out.println(canConstructWord("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", new String[]{"e", "ee", "eee", "eeee", "eeeee", "eeeeee",
                "eeeeeeee", "eeeeeeeeeeeee"}));

        System.out.println(String.format("ResponseTime of canConstructWordMemo without Memoization %d ms", System.currentTimeMillis() - startTime));

        */


        //Using Memoization tech

        Map<String, Boolean> cache = new HashMap<>();
        System.out.println(canConstructWordMemo("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"}, cache));
        cache = new HashMap<>();
        System.out.println(canConstructWordMemo("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"}, cache));

        cache = new HashMap<>();
        long startTime = System.currentTimeMillis();
        System.out.println(canConstructWordMemo("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", new String[]{"e", "ee", "eee", "eeee", "eeeee", "eeeeee",
                "eeeeeeee", "eeeeeeeeeeeee"}, cache));

        System.out.println(String.format("ResponseTime of canConstructWordMemo with Memoization %d ms", System.currentTimeMillis() - startTime));


    }

    public static boolean canConstructWord(String word, String[] wordbank){
        if(word == null || word.isEmpty()){
            return true;
        }

        for(String s: wordbank){
            if(word.indexOf(s) == 0){
                String remainingWord = word.substring(s.length());
               if(canConstructWord(remainingWord, wordbank)){
                   return true;
               }
            }
        }
        return false;
    }

    public static boolean canConstructWordMemo(String word, String[] wordbank, Map<String, Boolean> cache){
        if(cache.get(word) != null){
            return cache.get(word);
        }
        if(word == null || word.isEmpty()){
            return true;
        }

        for(String s: wordbank){
            if(word.indexOf(s) == 0){
                String remainingWord = word.substring(s.length());
                if(canConstructWordMemo(remainingWord, wordbank, cache)){
                    cache.put(word, true);
                    return true;
                }
            }
        }
        cache.put(word, false);
        return false;
    }
}
