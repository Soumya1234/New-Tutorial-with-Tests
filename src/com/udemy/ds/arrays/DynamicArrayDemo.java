package com.udemy.ds.arrays;

public class DynamicArrayDemo {
	public static void main(String[] args) {
		IntDynamicArray array = new IntDynamicArray(4);
		for (int i = 0; i<20; i+=2) {
			array.add(i);
		}
		
		System.out.println(array);
	
	}
}
