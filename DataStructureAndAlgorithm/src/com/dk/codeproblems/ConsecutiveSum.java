package com.dk.codeproblems;

public class ConsecutiveSum {

	public static void main(String[] args) {
		System.out.println(consecutiveSum(165));
	}
	
	
	public static int consecutiveSum(long num) {
		long sum = 0l;
		int noOfOccurrence = 0;
		
		long tries = num/2;
		
		if(num %2 != 0) {
			tries++;
		}
		
		long j = 1;
		long i = j;
		
		while(j < tries) {
			i = j;
			while(i <= tries) {
				sum = sum + i;
				i++;
				if(sum == num) {
					noOfOccurrence++;
					sum = 0L;
					break;
				}
				
				if(sum > num) {
					sum = 0L;
					break;
				}
			}
			sum = 0L;
			j++;
		}
		return noOfOccurrence;
	}

}
