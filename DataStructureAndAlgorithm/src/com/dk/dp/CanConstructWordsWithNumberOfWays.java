package com.dk.dp;

import java.util.HashMap;
import java.util.Map;

public class CanConstructWordsWithNumberOfWays {
    public static void main(String ...args){
        System.out.println(countConstruct("purple", new String[]{"purp", "p", "ur", "le", "purpl"}));
        System.out.println(countConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"}));
        System.out.println(countConstruct("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"}));

        Map<String, Integer> cache = new HashMap<>();
        System.out.println(countConstructMemo("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"}, cache));
        cache = new HashMap<>();
        System.out.println(countConstructMemo("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"}, cache));

        cache = new HashMap<>();
        long startTime = System.currentTimeMillis();
        System.out.println(countConstructMemo("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", new String[]{"e", "ee", "eee", "eeee", "eeeee", "eeeeee",
                "eeeeeeee", "eeeeeeeeeeeee"}, cache));

        System.out.println(String.format("ResponseTime of canConstructWordMemo with Memoization %d ms", System.currentTimeMillis() - startTime));
    }

    public static int countConstruct(String word, String[] wordbank){
        if(word == null || word.isEmpty()){
            return 1;
        }
        int totalCount = 0;
        for(String wb: wordbank){
            if(word.indexOf(wb) == 0){
                int localCount = countConstruct(word.substring(wb.length()), wordbank);
                totalCount += localCount;
            }
        }

        return totalCount;
    }

    public static int countConstructMemo(String word, String[] wordbank, Map<String, Integer> cache){
        if(cache.get(word)!= null){
            return cache.get(word);
        }
        if(word == null || word.isEmpty()){
            return 1;
        }
        int totalCount = 0;
        for(String wb: wordbank){
            if(word.indexOf(wb) == 0){
                int localCount = countConstructMemo(word.substring(wb.length()), wordbank, cache);
                totalCount += localCount;
            }
        }
        cache.put(word, totalCount);
        return totalCount;
    }
}
