package com.dk.strings;

public class ValidAnagram {
    public static void main(String ...args){
        System.out.println(isAnagram("anagram", "nagaram"));
        System.out.println(isAnagram("rat", "car"));
    }
    public static boolean isAnagram(String s, String t) {
        if(s != null && t != null && s.length() != t.length()){
            return false;
        }
        if(s == null && t == null){
            return true;
        }
        int []chS = new int[26];
        int []chT = new int[26];
        for(int i = 0; i < s.length(); i++){
            chS[s.charAt(i) - 'a']++;
            chT[t.charAt(i) - 'a']++;
        }

        for(int j = 0; j < 26; j++){
            if(chS[j] != chT[j]){
                return false;
            }
        }

        return true;
    }
}
