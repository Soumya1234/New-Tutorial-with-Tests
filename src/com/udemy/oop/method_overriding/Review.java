package com.udemy.oop.method_overriding;

public class Review {
	private String review;
	private boolean approved;
	
	public Review(String review) {
		this.review = review;
	}
	public boolean isApproved() {
		return approved;
	}
	public void setApproved(boolean approved) {
		this.approved = approved;
	}
	
	
}
