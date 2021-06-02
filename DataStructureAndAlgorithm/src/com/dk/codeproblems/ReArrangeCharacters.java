package com.dk.codeproblems;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReArrangeCharacters {

    /*Given a string with repeated characters, the task is to rearrange characters in a string so that no two adjacent characters are same.
    Note : It may be assumed that the string has only lowercase English alphabets.
    Examples:


    Input: aaabc
    Output: abaca

    Input: aaabb
    Output: ababa

    Input: aa
    Output: Not Possible

    Input: aaaabc
    Output: Not Possible

     */

    public static void main(String ...args){
        System.out.println(reArrangeCharacters("aaabb"));
        System.out.println(reArrangeCharacters("aaabc"));
    }

    public static String reArrangeCharacters(String str){
        StringBuilder builder = new StringBuilder();
        Map<Character, Integer> chMapping = new HashMap<>();
        for(int i = 0; i < str.length(); i++){
            chMapping.put(str.charAt(i), chMapping.getOrDefault(str.charAt(i), 0)+1);
        }
        PriorityQueue<KeyChars> queue = new PriorityQueue<>(new KeyCharsComparator());
        chMapping.entrySet().forEach(e ->{
            queue.add(new KeyChars(e.getKey(), e.getValue()));
        });

        KeyChars prev = new KeyChars('#', -1);

        while(!queue.isEmpty()){
            KeyChars key = queue.peek();
            queue.poll();
            builder.append(key.key);
            if(prev.freq > 0){
                queue.add(prev);
            }
            key.freq--;
            prev = key;
        }
        String result = builder.toString();
        if(result.length() != str.length()){
            System.out.println("Not Possible");
            return null;
        }

        return result;

    }


}

class KeyChars {
    Character key;
    Integer freq;

    KeyChars(Character key, Integer freq){
        this.key = key;
        this.freq = freq;
    }

}

class KeyCharsComparator implements Comparator<KeyChars> {

    @Override
    public int compare(KeyChars o1, KeyChars o2) {
        if(o1.freq < o2.freq){
            return 1;
        }else if(o1.freq > o2.freq){
            return -1;
        }
        return 0;
    }
}
