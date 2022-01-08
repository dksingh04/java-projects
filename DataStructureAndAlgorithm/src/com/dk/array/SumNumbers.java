package com.dk.array;

import java.util.Arrays;

public class SumNumbers {

    public static void main(String ...args){
        System.out.println(getSum("1,2,3,a,6,0,1"));
    }

    public static int getSum(String input){
        int sum = Arrays.stream(input.split(",")).map(s -> isNumeric(s))
                .reduce(0, (subtotal, element) -> subtotal + element);
        return sum;
    }


    public static Integer isNumeric(String number){
        try{
          return Integer.valueOf(number);
        }catch(Exception e){
            return 0;
        }
    }
}
