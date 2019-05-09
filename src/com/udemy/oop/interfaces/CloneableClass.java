package com.udemy.oop.interfaces;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CloneableClass extends SuperClass implements Cloneable {
	private int data;
	private String name;
	private List<String> certificates;

	public CloneableClass(int data, String name, List<String> certificates) {
		this.data = data;
		this.name = name;
		this.certificates = certificates;
	}

	public int getData() {
		return data;
	}

	public String getName() {
		return name;
	}

	public List<String> getCertificates() {
		return certificates;
	}

	@Override
	protected CloneableClass clone() {
		CloneableClass c = null;
		try {
			c = (CloneableClass) super.clone();
		} catch (CloneNotSupportedException e) {

		}
		//c.certificates = new ArrayList<String>();
		// Creating a Deep Copy of the mutable list
		for(int i = 0;i<this.certificates.size();i++) {
			c.certificates.add(this.certificates.get(i));
		}
		return c;
	}

}
