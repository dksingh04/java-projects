package com.dk.array;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String ...args){
        int [] nums1 = new int[]{1,2,3,0,0,0};
        int m = 3;
        int [] nums2 = new int[]{2,5,6};
        int n = 3;

        merge(nums1, m, nums2, n);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int [] merged = new int[m+n];
        int left = 0;
        int right = 0;
        int i = 0;
        while(left < m && right < n){
            if(nums1[left] <= nums2[right]) {
                merged[i] = nums1[left];
                left++;
            } else {
                merged[i] = nums2[right];
                right++;
            }
            i++;
        }

        while(left < m){
            //copy left array values
            merged[i] = nums1[left];
            left++;
            i++;
        }

        while(right < n){
            //copy right array values
            merged[i] = nums2[right];
            right++;
            i++;
        }

        Arrays.stream(merged).forEach(System.out::print);
    }
}
