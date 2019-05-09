package com.udemy.io;

import java.io.Serializable;

public class MySerializableClass implements Serializable {
	private static final long serialVersionUID = -3783676450483759117L;
	private String name;
	private String name2;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	private transient int id = 4; //won't be serialized and will be assigned default value( which is 0 btw) at the time of desrialization
	
	public int getId() {
		return this.id;
	}

	
	  public String getName2() { return name2; }
	 

}
