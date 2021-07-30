package com.dk.array;

public class BinarySearch {
    public static void main(String ...args){
        System.out.println(search(new int[]{-1,0,3,5,9,12}, 9));
    }
    public static int search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    public static int binarySearch(int[] nums, int start, int end, int target){

        int mid = (start + end) >>> 1;
        if(start <= end){
            if(nums[mid] == target){
                return mid;
            }

            if(target < nums[mid]){
                return binarySearch(nums, start, mid - 1, target);
            }else{
                return binarySearch(nums, mid + 1, end, target);
            }
        }

        return -1;
    }
}
