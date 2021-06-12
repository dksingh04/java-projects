package com.dk.array;

import java.util.Arrays;

public class ReplaceElementWithGreatestElemRightSide {

    public static void main(String ...args){
        /*
          Replace Elements with Greatest Element on Right Side
          Example 1:

            Input: arr = [17,18,5,4,6,1]
            Output: [18,6,6,6,1,-1]
            Explanation:
            - index 0 --> the greatest element to the right of index 0 is index 1 (18).
            - index 1 --> the greatest element to the right of index 1 is index 4 (6).
            - index 2 --> the greatest element to the right of index 2 is index 4 (6).
            - index 3 --> the greatest element to the right of index 3 is index 4 (6).
            - index 4 --> the greatest element to the right of index 4 is index 5 (1).
            - index 5 --> there are no elements to the right of index 5, so we put -1.

           Example 2:

            Input: arr = [400]
            Output: [-1]
            Explanation: There are no elements to the right of index 0.

         */

        int [] res = replaceElements(new int []{17,18,5,4,6,1});
        ArrayUtils.print(res);
        System.out.println();
        System.out.println("************************ Efficient Solution *****************************");
        int [] res1 = replaceElementsON(new int []{17,18,5,4,6,1});
        ArrayUtils.print(res1);
    }
    // basic solution.
    public static int[] replaceElements(int[] arr) {
        int max_val = Integer.MIN_VALUE;
        for(int i = 1; i < arr.length; i++){
            max_val = Integer.MIN_VALUE;
            for(int j = i; j < arr.length; j++){
                if(arr[j] != 0 && arr[j] > max_val){
                    max_val = arr[j];
                }
            }
            arr[i-1] = max_val;
        }

        if(max_val == Integer.MIN_VALUE){
            arr[0] = -1;
        }

        arr[arr.length - 1] = -1;

        return arr;

    }

    //efficient soln,
    public static int[] replaceElementsON(int[] arr) {
        int last = arr.length - 1;
        int prev = 0;
        int greatest = arr[last];

        for(int i = last; i >= 1; i--){
            if(prev > greatest){
                greatest = prev;
            }
            prev = arr[i - 1];
            arr[i - 1] = greatest;
        }
        arr[last] = -1;
        return arr;
    }



}
