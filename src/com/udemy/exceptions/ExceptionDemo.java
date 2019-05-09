package com.udemy.exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionDemo {
	public static void main(String[] args) throws IOException {
		System.out.println("\nInside main()... ");
		share();
		System.out.println("\nEnd of main()... ");
	}

	public static void share()  throws IOException  {
		System.out.println("\nInside share()... ");
		try {
			HttpConnect.send(1, "hello", "http://www.goodsnips.com");
			System.out.println("\nAfter invoking send()...");
		} catch (FileNotFoundException e) {
			System.out.println("\nInside share()'s catch block for FileNotFoundException");
			throw e;
		} catch (IOException e) {
			System.out.println("\nConnecting to a different server");
		} finally {
			System.out.println("Inside share()'s finally...");
		}

		System.out.println("\nEnd of share()... ");
	}
}
