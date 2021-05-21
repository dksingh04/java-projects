package com.dk.codeproblems;

public class CountEvenDigits {
    public static void main(String ...args){
        System.out.println(findNumbers(new int[]{555,901,482,1771}));
        //System.out.println(10/10);
    }

    public static int findNumbers(int[] nums) {
        int count = 0;
        int countEvenNumber = 0;
        for(int i = 0; i < nums.length; i++){
            int temp = nums[i]/10;
            if(temp == 0){
                count++;
            }
            while(temp > 0){
                count++;
                temp = temp/10;
                if(temp == 0){
                    count++;
                }
            }
            if(count != 0 && count % 2 == 0){
                countEvenNumber++;
            }
            count = 0;
        }

        return countEvenNumber;
    }

}
