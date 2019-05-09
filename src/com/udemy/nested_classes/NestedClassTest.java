package com.udemy.nested_classes;

import java.util.Arrays;
import java.util.Comparator;

import com.udemy.oop.school.Student;

public class NestedClassTest {
	public static void main(String[] args) {
		Cache cache  = new Cache(5);
		Student s1 = new Student("Soumyadeep","MALE");
		Student s2 = new Student("Soumya","MALE");
		Student s3 = new Student("Bimalendu","MALE");
		Student s4 = new Student("Ritesh","MALE");
		Student s5 = new Student("Rahul","MALE");
		//Student s6 = new Student("Sarathi","MALE");
		cache.add(s1);
		cache.add(s2);
		cache.add(s3);
		cache.add(s4);
		cache.add(s5);
		
		CacheIterator iterator = cache.iterator();
		while(iterator.hasNext()) {
			System.out.println(((Student)iterator.next()).getName());
		}
		/*
		 * Arrays.sort(cache.students, Cache.ID_COMPARISON_DESC);
		 * System.out.println("After sorting in descending order of ID...");
		 * CacheIterator iterator2 = cache.iterator(); while(iterator2.hasNext()) {
		 * System.out.println(((Student)iterator2.next()).getName()); }
		 */
		Cache.FOO.go();
	}
}
