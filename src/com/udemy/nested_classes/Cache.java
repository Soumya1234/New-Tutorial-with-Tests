package com.udemy.nested_classes;

import java.util.Comparator;

import com.udemy.oop.school.Student;

interface CacheIterator {
	boolean hasNext();

	Object next();
}

class Foobar {
	protected int y;

	Foobar(int x) {
		y = x;
	}

	public void go() {
		System.out.println("The value of y: " + y);
	}
}

public class Cache {
	public Student[] students;
	private int index;
	/*
	 * public static final Comparator<Student> ID_COMPARISON_DESC = new
	 * Comparator<Student>() {
	 * 
	 * @Override public int compare(Student o1, Student o2) { // TODO Auto-generated
	 * method stub return o1.getId()<o2.getId()? 1:-1; }
	 * 
	 * } ;
	 */

	public static final Foobar FOO = new Foobar(5) {
		@Override
		public void go() {
			System.out.println("Inside go() method of Anonymous class");
			super.go();
		}
	};

	public Cache(int size) {
		students = new Student[size];
		index = 0;
	}

	public CacheIterator iterator() {
		return new MyCacheIterator();
	}

	public void add(Student s) {
		students[index++] = s;
	}

	/*
	 * This non static member class acts as an adapter for the Cache class
	 */
	private class MyCacheIterator implements CacheIterator {

		int i;

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return i < students.length;
		}

		@Override
		public Object next() {
			// TODO Auto-generated method stub
			return students[i++];
		}

	}
}
