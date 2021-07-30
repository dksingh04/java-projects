package com.dk.strings;

public class ValidPalendrome {

    public static void main(String ...args){
        System.out.println(isPalindrome("race a car"));
        System.out.println(isPalindrome("0P"));

        System.out.println(isPalindromeOptimized("race a car"));
        System.out.println(isPalindromeOptimized("A man, a plan, a canal: Panama"));
    }

    public static boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        s = s.toLowerCase();
        while(l < r){
            if(((s.charAt(l) >= '0' && s.charAt(l) <= '9') || (s.charAt(l) >= 'a' && s.charAt(l) <= 'z'))
                    && ((s.charAt(r) >= '0' && s.charAt(r) <= '9') || (s.charAt(r) >= 'a' && s.charAt(r) <= 'z'))){
                if(s.charAt(l) != s.charAt(r)){
                    return false;
                }
                l++;
                r--;

            }else{
                while(l < r && !((s.charAt(l) >= '0' && s.charAt(l) <= '9') || (s.charAt(l) >= 'a' && s.charAt(l) <= 'z'))){
                    l++;
                }

                while(l < r && !((s.charAt(r) >= '0' && s.charAt(r) <= '9') || (s.charAt(r) >= 'a' && s.charAt(r) <= 'z'))){
                    r--;
                }
            }
        }

        return true;
    }

    public static boolean isPalindromeOptimized(String s){
        int l = 0;
        int r = s.length()-1;
        while(l < r){
            if(!isValidChar(s.charAt(l))){
                l++;
                continue;
            }
            if(!isValidChar(s.charAt(r))){
                r--;
                continue;
            }
            if(Character.toLowerCase(s.charAt(l++)) != Character.toLowerCase(s.charAt(r--))){
                return false;
            }
        }
        return true;
    }

    public static boolean isValidChar(char c) {
        return (c >= 'A' && c <= 'Z') ||
                (c >= 'a' && c <= 'z') ||
                (c >= '0' && c <= '9');
    }
}
