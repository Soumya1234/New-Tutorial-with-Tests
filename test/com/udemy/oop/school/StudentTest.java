package com.udemy.oop.school;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

class StudentTest {

	@Test
	void testEnroll() {
		/*
		 * Test to ensure that a Student object can enroll courses within the enroll
		 * limit
		 */

		// Preparing the input
		Student student1 = new Student("John", "male");
		Course course1 = new Course(1, "Java in depth", null);

		// Execute the method
		student1.enroll(course1);

		// Test the output
		assertTrue("Course enroll limit exceeded", student1.getEnrolledCourses().size() <= Student.COURSE_ENROLL_LIMIT);

		Course course2 = new Course(2, "Algorithm", "CS");

		student1.enroll(course2);

		assertTrue("Course enroll limit exceeded", student1.getEnrolledCourses().size() <= Student.COURSE_ENROLL_LIMIT);

		Course course3 = new Course(3, "AI", "CS");

		student1.enroll(course3);

		assertTrue("Course enroll limit exceeded", student1.getEnrolledCourses().size() <= Student.COURSE_ENROLL_LIMIT);

		Course course4 = new Course(4, "Automata", "CS");

		student1.enroll(course4);
        
		
		assertTrue("Course enroll limit exceeded", student1.getEnrolledCourses().size() <= Student.COURSE_ENROLL_LIMIT);
		assertEquals(student1.getEnrolledCourses().size(),3);
	}

}
