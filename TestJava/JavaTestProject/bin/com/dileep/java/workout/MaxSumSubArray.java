package com.dileep.java.workout;

public class MaxSumSubArray {

	public static void main(String[] args) {
		int arr[] = {1,-1,2,4,0,5,2,-9,19,2,4,45,-6,2};
		maxSumSubArray(arr);
	}
private static void maxSumSubArray(int arr[]){
	
	int currentStart = 0 ; 
	int currentEnd = 0;
	int currentSum = 0 ;
	int maxStart = 0;
	int maxEnd  =0 ;
	int maxSum = 0;
	while (currentEnd != arr.length ){
		currentSum += arr[currentEnd];
		if(currentSum >  maxSum){
			maxSum =  currentSum ;
			maxStart =  currentStart;
			maxEnd =  currentEnd;
		}
		if(currentSum <= 0 ){
			currentStart = currentEnd + 1;
			currentSum = 0 ;
		}
		currentEnd++;
	}
	System.out.println("max sum = "+maxSum);
	System.out.println("Max points  :: maxStart = "+ maxStart +"maxEnd  = "+maxEnd);
}
}
