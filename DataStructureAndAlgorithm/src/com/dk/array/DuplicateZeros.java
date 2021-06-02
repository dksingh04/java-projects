package com.dk.array;

import java.util.Arrays;

public class DuplicateZeros {
        public static void main(String ...args){
            duplicateZeros(new int[]{1,0,2,3,0,4,5,0});
        }
        public static void duplicateZeros(int[] arr) {
            for(int i = 0; i < arr.length - 1; i++){
                if(arr[i] == 0){
                    int temp = arr[i+1];
                    arr[++i] = 0;
                    int j = i+1;
                    while(j < arr.length){
                        int temp2 = arr[j];
                        arr[j] = temp;
                        temp = temp2;
                        j++;
                    }
                }
            }

            Arrays.stream(arr).forEach(System.out::print);

        }

}
