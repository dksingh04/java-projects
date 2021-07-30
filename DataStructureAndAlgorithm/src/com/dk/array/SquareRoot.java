package com.dk.array;

public class SquareRoot {
    private static final double EPSILON = 0.000000000000001;
    public static void main(String ...args){
        /*
          Set low = 0 and high = 1 + n / 2
            while True:
                mid = (low + high) / 2
                square = mid * mid
                If the square is equal to 'n' then
                    return mid (mid is the square root)
                Else If the square is less than n:
                    low = mid (square root lies in the upper half, i.e., between mid and high)
                Else If the square is greater than n then
                    high = mid (square root lies in the lower half, i.e., between low and mid)
         */

        double [] arr = {16, 17, 2.25, 4};
        for (double i : arr)
            System.out.println("Square root of " + i + " is " + squareRoot(i));
    }

    public static double squareRoot(double num) {
        double low = 0;
        double high = 1 + num/2;
        return squareRootRec(num, low, high);
    }

    public static double squareRootRec(double num, double low, double high) {
        if(low < high){
            double mid = (low + high)/2;
            double sqr = mid * mid;
            double diff = Math.abs(num - sqr);
            if(diff <= EPSILON) {
                return mid;
            }
            if(sqr < num){
                return squareRootRec(num, mid, high);
            }else{
                return squareRootRec(num, low, mid);
            }
        }


        return -1;
    }
    //Leet code soln
    public int mySqrt(int x) {
        int low = 0, high = x;
        int ans = 1;

        if(x==0) return 0;
        if(x==1) return 1;

        while(low<=high){

            int mid = low + ((high-low) >> 1);

            if(mid > x/mid){
                high = mid-1;
            }else{
                ans = mid;
                low = mid+1;
            }
        }

        return ans;
    }
}
