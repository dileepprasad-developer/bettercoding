package com.dileep.java.workout;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

public class Test1 {

	com.dileep.java.workout.Test test1 =  new com.dileep.java.workout.Test();
	
	@Test
	public void test() {
		int arr1[] = {3,5,3,-8,2,8};
		org.junit.Assert.assertEquals(13, test1.getMaxArray(arr1));
	}

}
