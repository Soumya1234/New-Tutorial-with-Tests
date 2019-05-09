package com.udemy.oop.interfaces;

import java.util.ArrayList;
import java.util.Iterator;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> a = new ArrayList();
		a.add("OCAJP");
		a.add("OCPJP");
		a.add("PMP");
		CloneableClass c= new CloneableClass(1,"A",a);
		CloneableClass d = c.clone();
		System.out.println(d.getData());
		System.out.println(d.getName());
		Iterator<String> i = d.getCertificates().iterator();
		while(i.hasNext()) {
			System.out.println(i.next());
		}
		
	}

}
