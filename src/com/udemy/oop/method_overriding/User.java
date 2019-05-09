package com.udemy.oop.method_overriding;

public class User {
	int id =1;
	public Review postAReview(String review) {
		System.out.println("User: postAReview()");
		Review r = new Review(review);
		return r;
	}
	public static void main(String[] args) {
		User user = new Staff();
		user.postAReview("");
		((Staff)user).printId();
	}
}
