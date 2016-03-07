package com.dileep.java.workout;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;



public class TestNthLargest {

	public static void main(String[] args) {
        
        int[] input = { 4, 2, 9, 6, 23, 12, 34, 1 , 9};
        Arrays.sort(input);
        for(int i =0 ; i < input.length ; i++ ){
        	System.out.print(" "+ input[i]);
        }
        int num = 1000;
        int pos =  findArrayPosition(input , num , 0 ,input.length-1);
        if(pos != -1){
        	rearrangeArray(input , num , pos);
        }
        //insertionSort(input);
        System.out.println();
        for(int i =0 ; i < input.length ; i++ ){
        	System.out.print(" "+ input[i]);
        }
    }
     
	private static int findArrayPosition(int[] input ,  int num , int beginIndex , int endIndex){
		
		if(input[endIndex] <= num)
			return endIndex;
		if(input[beginIndex] > num)
		 return -1 ;
		
		int mid = (beginIndex +  endIndex) / 2;
		
		if(input[mid] <= num && input[mid+1] > num)
			return mid;
		
		if(input[mid] <= num){
		return findArrayPosition(input , num , mid+1 , endIndex);
		}
		else{
			return findArrayPosition(input , num , beginIndex , mid -1);
		}
		
	}
	private static void rearrangeArray(int[] input ,  int num , int pos){
		for(int i=0 ;  i <pos  ; i++){
			input[i] =input[i+1]; 
		}
		input[pos] = num ;
	}
    private static void printNumbers(int[] input) {
         
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + ", ");
        }
        System.out.println("\n");
    }
 
    public static void insertionSort(int array[]) {
        int n = array.length;
        for (int j = 1; j < n; j++) {
            int key = array[j];
            int i = j-1;
            while ( (i > -1) && ( array [i] > key ) ) {
                array [i+1] = array [i];
                i--;
            }
            array[i+1] = key;
            printNumbers(array);
        }
    }

}
