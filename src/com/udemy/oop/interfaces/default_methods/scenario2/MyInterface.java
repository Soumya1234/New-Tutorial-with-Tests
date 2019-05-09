package com.udemy.oop.interfaces.default_methods.scenario2;

public interface MyInterface {
	default void go() {
		System.out.println("MyInterface: go()");
	}
}
