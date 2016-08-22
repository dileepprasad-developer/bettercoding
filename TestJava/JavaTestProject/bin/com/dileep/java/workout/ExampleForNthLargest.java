package com.dileep.java.workout;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * @author Dileep
 *
 *This code find out the nth largest number with the given input format
 * input format
 *   1 2 3 4 | 3 \n
 *   left hand side of pipe is the number seperated by space from which nth largest is to be found
 *   right hand side of pipe is the value of n(rank of heighest)
 */
public class ExampleForNthLargest {
	public static void main(String[] args) {
		
				/*
				 * This code supports only the data given in the format  1 2 3 4 | 3 which is inputed through console
				 * must do small enhancement to read from file as well
				 */
		        try (Scanner scanner = new Scanner(System.in)) {
		            System.out.print("Enter Your String  specify the nth value after pipe - Example  1 2 3 4 | 3 \n ");
		            String text= scanner.nextLine();
		           String textforSeperator = text.replaceAll("\\s+","");
		           /*
		            * below 2 lines are ugly way of extracting value of N
		            * Must change this code to read large String and data from file for better reliability
		            */
		           String[] index = textforSeperator.split("\\|");
		           Integer maxRangeNumber = Integer.parseInt(index[1]);
		           System.out.println("\n\n"+maxRangeNumber+"th Largest Number to be found");
		           @SuppressWarnings("resource")
		           Scanner splitter = new Scanner(text).useDelimiter("\\s");
		           int[] ascendingOrderArray = new int[maxRangeNumber];
		           ascendingOrderArray = getSortedInitialArray(splitter ,maxRangeNumber ,ascendingOrderArray );
		           ascendingOrderArray = returnFinalArray(splitter  ,ascendingOrderArray );
		          System.out.println("\n\nThe "+ maxRangeNumber +"th Largest Number is  "+ ascendingOrderArray[0]);
		        }
		        catch (Exception e) {
		        	            e.printStackTrace(System.err);
		       }

}
	/**
	 * 
	 * @param splitter
	 * @param maxRangeNumber
	 * @param ascendingOrderArray
	 * @return
	 * 
	 * This method reads the first n numbers and store it into an array of size n
	 * all future comparisons are going to happen in this array
	 * This array is sorted in the ascending order using quick sort (using java API)
	 * this is done only once with a complexity of O(n log n) 
	 */
	private static int [] getSortedInitialArray( Scanner splitter , int maxRangeNumber ,  int[] ascendingOrderArray){
		int i =0;
        while(i < maxRangeNumber && splitter.hasNext()){
     	   String nextNumber = splitter.next();
     	   ascendingOrderArray[i] = Integer.parseInt(nextNumber);
     	   i++;
        }
         Arrays.sort(ascendingOrderArray);
         return ascendingOrderArray;
	}
	/**
	 * 
	 * @param input
	 * @param num
	 * @param beginIndex
	 * @param endIndex
	 * @return
	 * This method is used to find the best suited position of the next number which is read iteratively
	 * if the next element is smaller than the first array element, it is neglected
	 * 	else suitable position is sought using recursive devide and conquer method
	 *  worst case time complexity is O(n2) and average case is O (n log n)
	 */
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
			return findArrayPosition(input , num , beginIndex , mid -1);
	}
	/**
	 * 
	 * @param input
	 * @param num
	 * @param pos
	 * Rearranges the array to keep the n largest numbers only by insterting
	 * the current number into position and re adjusting the previous position
	 *  0th postion will be removed
	 *  O(n) is the worst case and o(log n) average.
	 */
	private static void rearrangeArray(int[] input ,  int num , int pos){
		for(int i=0 ;  i <pos  ; i++){
			input[i] =input[i+1]; 
		}
		input[pos] = num ;
	}
	
	/**
	 * 
	 * @param splitter
	 * @param ascendingOrderArray
	 * @return
	 * 
	 * consolidation method
	 */
	private static int[] returnFinalArray(Scanner splitter , int[] ascendingOrderArray){
		 
        while(splitter.hasNext()){
     	   String nextNumber = splitter.next();
     		   Arrays.sort(ascendingOrderArray); 
     		   if(nextNumber.indexOf('|') != -1){
     		   break;
     		   }
     		   else{
     			   int pos =  findArrayPosition(ascendingOrderArray , Integer.parseInt(nextNumber) , 0 ,ascendingOrderArray.length-1);  
     			   if(pos != -1){
     				   rearrangeArray(ascendingOrderArray , Integer.parseInt(nextNumber) , pos);
     			    }
     		   }
     	   }
        return ascendingOrderArray;
	}
}