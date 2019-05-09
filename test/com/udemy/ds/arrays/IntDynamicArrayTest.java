package com.udemy.ds.arrays;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class IntDynamicArrayTest {

	@Test
	void testSize() {
		IntDynamicArray array = new IntDynamicArray();
		assertEquals(array.size(), 0);
		// Adding 35 elements to the array
		for (int i = 0; i < 35; i++) {
			array.add(i);
		}
		assertEquals(array.size(), 35);
	}

	@Test
	void testIsEmpty() {
		IntDynamicArray array = new IntDynamicArray();
		assertTrue(array.isEmpty(), "Newly Created Dynamic array should be empty");
	}

	@Test
	void testClear() {
		IntDynamicArray array = new IntDynamicArray();
		// Adding 35 elements to the array
		for (int i = 0; i < 35; i++) {
			array.add(i);
		}
		array.clear();
		assertTrue(array.isEmpty(), "Array should be empty after clear operation");
	}

	@Test
	void testContains() {
		IntDynamicArray array = new IntDynamicArray();
		// Adding 35 elements to the array
		for (int i = 0; i < 35; i++) {
			array.add(i);
		}
		assertTrue(array.contains(34), "Array should contain 34");
		assertFalse(array.contains(35), "Array shouldn't contain 35");
	}

	@Test
	void testRemoveFromEmptyArray() {
		
		IntDynamicArray array = new IntDynamicArray();
		assertThrows(Exception.class, new Executable() {

			@Override
			public void execute() throws Throwable {
				array.removeAt(0);
			}
			
		});
	}
	
	@Test
	void testRemoveIndexOutOfBounds(){
		IntDynamicArray array = new IntDynamicArray();
		array.add(1);
		array.add(34);
		array.add(23);
		assertThrows(IllegalArgumentException.class, new Executable() {

			@Override
			public void execute() throws Throwable {
				array.removeAt(5);
			}
			
		});
	}
	
	@Test
	void testRemoving() {
		//Setting up the sample input
		int[] list = {23,54,45,67,12,988,56,43,45};
		IntDynamicArray array = new IntDynamicArray(list);
		
		//executing the method under test
		boolean ret = array.remove(23);
		
		//setting up the expected result
		int[] expected_list_after_removal = {54,45,67,12,988,56,43,45};
		
		//validating the test results
		assertEquals(8,array.size());
		assertTrue(ret);
		assertArrayEquals(expected_list_after_removal,array.toStaticArray());
		
		//repeating the above process
		ret = array.remove(23);
		assertFalse(ret);
		
		ret = array.remove(68);
		assertFalse(ret);
		
	}

}
