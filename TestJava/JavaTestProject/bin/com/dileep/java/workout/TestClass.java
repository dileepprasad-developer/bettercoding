package com.dileep.java.workout;


public class TestClass {
public static void main(String[] args) {
	 //int a[] = {1,2,5,4,5,4};
	//String a ="5 6 + -";
	 //System.out.println(solution(a));
	//System.out.println(stringReplace("test123999123" ,  "123" ,  "456789" ));
	createSubStrings( "abc" );
	crateCombination("","abc");
	// solution(24);
/*	
	String str ="hello";
	int[] letters = new int[256];
	char[] s_array = str.toCharArray();
	
	for (char c : s_array) { // count number of each char in s.
		 letters[c]++; 
		 }*/
	
	
}
/*public static int solution(int[] A) {
    // write your code in Java SE 8
	  int i = 0; 
	    int j= 1;
	    int size = 2;
	    int firstElement = A[i];
	    int secondElement = A[j];
	    while(j < A.length-1){
	        i=i+2;
	        j=j+2;
	        if(firstElement == A[i] || secondElement == A[i]) {
	        size=size+1;
	        
	        if(secondElement == A[j] || firstElement == A[j]){
		        size=size+1;
		        }
	        }
	       
	        firstElement = A[i];
	         secondElement = A[j];
	    }
	    return size;
}*/

/*private static void solution(int N) {
	int first =3, second = 5 , third =7;
  for(int i=1 ; i<= N ; i++){
	  if(i%(first * second* third) ==0){
		  System.out.println("FizzBuzzWoof");
	  }
	  else if(i%(first * second) == 0){
		  System.out.println("FizzBuzz");
	  }
	  else if(i%(third * second) == 0){
		  System.out.println("BuzzWoof");
	  }
	  else if(i%(first * third) == 0){
		  System.out.println("FizzWoof");
	  }
	  else  if(i%(third ) == 0){
		  System.out.println("Woof");
	  }
	  else  if(i%(second ) == 0){
		  System.out.println("Buzz");
	  }
	  else  if(i%(first ) == 0){
		  System.out.println("Fizz");
	  }
	  else{
		  System.out.println(i);

	  }
	  }
  }*/

private static int solution(String S) {
	String array[] =S.split(" ");
	int intarray[] =new int[array.length];
	int number = 0;
	int counter =0;
	for( String str :  array){
		
		try {
			 number = Integer.parseInt(str);
			 str = "VALIDNUMBER";
		} catch (NumberFormatException e) {
			//donothing
		}
		switch(str){
		
		case  "VALIDNUMBER" :
			intarray[counter] = number;
			counter++;
			break;
		case  "POP" : 
			if(counter-1 > -1){
			intarray[counter-1] = 0;
			counter--;
				break;
			}

		case "DUP" : 
			if(counter-1 > -1){
			int dupNumber = intarray[counter-1];
			 intarray[counter] =dupNumber;
				counter++;
				break;
			}

		case "+" : 
			if(counter-2 > -1){
			int dupNumber1 = intarray[counter-1];
			int dupNumber2 = intarray[counter-2];
			intarray[counter-2] =dupNumber1+dupNumber2;
			intarray[counter-1] =0; 
			counter--;
			break;
			}

		case "-" : 
			if(counter-2 > -1){
			int dupNumber3 = intarray[counter-1];
			int dupNumber4 = intarray[counter-2];
			intarray[counter-2] =dupNumber3-dupNumber4;
			intarray[counter-1] =0; 
			counter--;
			break;
			}

		 default :
			return -1 ;

		}
	}
	
	return intarray[counter-1];
}


static String stringReplace(String src, String match, String replace) {
    char srcarray[] = src.toCharArray();
    char matcharray[] = match.toCharArray();
    char replacearray[] = replace.toCharArray();
    if(null ==srcarray || srcarray.length <  1 )
    	return "";
    if(null ==matcharray || matcharray.length <  1 )
    	return src;
    if(null ==replace || replace.length() <  1){
    	replacearray =  new char[matcharray.length];
    }
	 
	 int j=0,i =0;
	 int index = -1;
    for( i = 0 ;  i <srcarray.length   ; i++ ){
    	
    	if(srcarray[i] == matcharray[j]){
    		index = i;
    			while(j <  matcharray.length){
    				if( srcarray[i] == matcharray[j]){
    				j++;i++;
    				continue;
    				}
    				else{
    					index = -1;
    					break;
    				}
    			}
    			if(index > -1){
    				char finalarray[] =  new char[srcarray.length + replacearray.length -matcharray.length ];
    				 System.arraycopy(srcarray , 0 ,finalarray , 0 , index  );
    				 for(int k = 0;  k< replacearray.length ; k++){
    					 finalarray[index+k]=replacearray[k]; 
    				 }
    				 System.arraycopy(srcarray , index+matcharray.length ,finalarray , index+replacearray.length , finalarray.length-(index+replacearray.length)  );
    				 srcarray = finalarray;
    				 System.out.println(new String(srcarray));
    	    		
    	    	}
    			j = 0 ;
    	}
    }
    
//System.out.println(new String(finalarray));
    return new String(srcarray);
}

private static void createSubStrings(String str ){
	
	for(int i=0 ; i<  str.length() ; i++){
		for (int j=i+1 ; j<= str.length() ; j++){
			System.out.println(str.substring(i,j));
		}
	}
}

	private static void crateCombination(String beg, String end) {
		if (end.length() <= 1) {
			System.out.println(beg + end);
		} else {
			for (int i = 0; i < end.length(); i++) {
				String n = end.substring(0, i) + end.substring(i + 1);
				crateCombination(beg + end.charAt(i), n);
			}
		}
	}
}
