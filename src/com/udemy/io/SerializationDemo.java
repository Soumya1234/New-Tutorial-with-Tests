package com.udemy.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationDemo {
	public static void main(String[] args) {
		//serialize();
		deserialize();
	}
	
	private static void serialize() {
		MySerializableClass object = new MySerializableClass();
		object.setName("JAVA");
		System.out.println("Before serialization:");
		System.out.println("name: "+object.getName());
		System.out.println("id: "+object.getId());
		System.out.println("Serializing object ...");
		try(ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("serial.ser")))){
			out.writeObject(object);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void deserialize() {
		MySerializableClass new_object = null;
		try(ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream("serial.ser")))){
			new_object=(MySerializableClass)in.readObject();
			System.out.println("Deserializing ...");
			System.out.println("After Deserialization:");
			System.out.println("name: "+new_object.getName());
			System.out.println("id: "+new_object.getId());
			System.out.println("name2: "+new_object.getName2());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}

