package com.udemy.oop.method_overriding;

public class Staff extends User {
	int id =2;
	public void printId() {
		System.out.println("id: "+id);
		System.out.println("super.id: "+super.id);
	}
	public Review postAReview(String review) {
		System.out.println("Staff: postAReview()");
		Review r = super.postAReview(review);
		r.setApproved(true);
		return r;
	}
}
