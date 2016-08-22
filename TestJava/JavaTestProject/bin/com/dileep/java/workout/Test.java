
package com.dileep.java.workout;



//Example : {3, 5, 3, -8, 2, 8} --> 13

//Example : { 1, -2, 3 } -> 3



public class Test {
	
	public int getMaxArray(int[] array){
		int maxSum = 0;
		int sum = 0 ; 
		
		for( int i = 0 ;  i< array.length ; i++){
			sum += array[i];
			if(maxSum  <  sum ){
				maxSum = sum; 
			}
			if( sum < 0 ){
				sum = 0; 
			}
			
		}
		return maxSum;
	}

}
