package com.dk.codeproblems;

import java.util.HashSet;
import java.util.Set;

public class FindSumOfTwoValue {
    public static void main(String[] args) {
        int[] v = new int[]{1, 3, 4, 5, 7, 14, 15}; //Sorted Array
        int[] test = new int[]{3, 20, 1, 2, 7};

        for (int i = 0; i < test.length; i++){
            boolean output = findSumOfTwo(v, test[i]);
            System.out.println("findSumOfTwo(v, " + test[i] + ") = " + (output ? "true" : "false"));
        }

        for (int i = 0; i < test.length; i++){
            boolean output = findSumOfTwo(v, test[i]);
            System.out.println("findSumOfTwo(v, " + test[i] + ") = " + (output ? "true" : "false"));
        }
        v = new int[]{2, 1, 8, 4, 7, 3};
        System.out.println(findSumOfTwoM1(v, 7));
    }
    //t(n) = n
    //(M(n) = n
    public static boolean findSumOfTwo(int [] A, int val){
        Set<Integer> s = new HashSet<>();
        for(int a : A){
            if(s.contains(val - a)){
                return true;
            }
            s.add(a);
        }
        return false;
    }

    //t(n) = n
    //M(n) = 1
    public static boolean findSumOfTwoM1(int [] A, int val){
        int left = 0;
        int right = A.length - 1;
        int sum = 0;
        while(left < right){
            sum = A[left] + A[right];
            if(sum == val){
                return true;
            }
            if(sum < val){
                left++;
            }else{
                right--;
            }
        }
        return false;
    }
}
