package com.udemy.encoding;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class IODemo {
	private static String inFile = "walden.jpg";
	private static String outFile = "walden_copy.jpg";

	public static void applyEncoding() {
		System.out.println("Inside applyEncodig ...");

		// Ensure eclipse property is set as UTF-8
		printEncodingDetails("a");
		printEncodingDetails("€");
		printEncodingDetails("\u1F602");

	}

	private static void printEncodingDetails(String symbol) {
		// TODO Auto-generated method stub
		System.out.println("symbol: " + symbol);

		// symbol.getBytes(String encodingScheme) encodes the string symbol with the
		// input encoding scheme
		try {
			System.out.println("ASCII: " + Arrays.toString(symbol.getBytes("US-ASCII")));
			System.out.println("ISO-8859-1: " + Arrays.toString(symbol.getBytes("ISO-8859-1")));
			System.out.println("UTF-8: " + Arrays.toString(symbol.getBytes("UTF-8")));
			System.out.println("UTF-16: " + Arrays.toString(symbol.getBytes("UTF-16")));
			System.out.println("UTF-16 BE: " + Arrays.toString(symbol.getBytes("UTF-16BE")));
			System.out.println("UTF-16 LE: " + Arrays.toString(symbol.getBytes("UTF-16LE")));
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
	}

	private static void fileCopyWithoutBuffer() {
		try (FileInputStream in = new FileInputStream(inFile); FileOutputStream out = new FileOutputStream(outFile)) {
			int byteRead;
			File fileInput = new File(inFile);
			System.out.println("File size: " + fileInput.length()+" bytes");
			long startTime = System.nanoTime();
			while ((byteRead = in.read()) != -1) {
				out.write(byteRead);
			}
			long endTime = System.nanoTime();
			System.out.println("elapsed time: " + (endTime - startTime) / 1000000 + " ms");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void fileCopyWithBuffer() {
		try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(inFile));
				BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(outFile))) {
			File fileInput = new File(inFile);
			System.out.println("File size: " + fileInput.length()+" bytes");
			byte[] byteArray = new byte[4000];
			long startTime = System.nanoTime();
			int noOfBytesRead;
			while ((noOfBytesRead = in.read(byteArray)) != -1) {
				out.write(byteArray, 0, noOfBytesRead);
			}
			long endTime = System.nanoTime();
			System.out.println("elapsed time: " + (endTime - startTime) / 1000000 + " ms");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void bufferedReaderDemo() {
		try {
			BufferedReader reader =new BufferedReader(new InputStreamReader(new FileInputStream("go.txt"),"UTF-8"));
			String line = null;
			StringBuilder text = new StringBuilder();
			while((line = reader.readLine())!=null) {
				text.append(line).append("\n");
			}
			System.out.println(text.toString());
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	private static void fileMethodDemo() {
System.out.println("\nInside fileMethodsDemo ...");
		
		File f = new File("E:"+File.separator+"eclipse projects"+File.separator+"Tutorial"+File.separator+"src"+File.separator+".."+File.separator+"walden.jpg"); // "movies\\movies.txt" also works
		//File f = new File("walden.jpg");
		
		System.out.println("getAbsolutePath(): " + f.getAbsolutePath());
		try {
			System.out.println("getCanonicalPath(): " + f.getCanonicalPath());
			System.out.println("createNewFile(): " + f.createNewFile());
		} catch (IOException e) {}		
		System.out.println("separator: " + File.separator); //required for system independence
		System.out.println("separatorChar: " + File.separatorChar);
		System.out.println("getParent(): " + f.getParent());
		System.out.println("lastModified(): " + f.lastModified());
		System.out.println("exists(): " + f.exists());
		System.out.println("isFile(): " + f.isFile());
		System.out.println("isDirectory(): " + f.isDirectory());
		System.out.println("length(): " + f.length());
		
		System.out.println("My working or user directory: " + System.getProperty("user.dir"));
		System.out.println("new File(\"testdir\").mkdir(): " + new File("testdir").mkdir());
		System.out.println("new File(\"testdir\\test\").mkdir(): " + new File("testdir\\test").mkdir());
		System.out.println("new File(\"testdir\").delete(): " + new File("testdir").delete());
		System.out.println("new File(\"testdir\\test1\\test2\").mkdir(): " + new File("testdir\\test1\\test2").mkdir());
		System.out.println("new File(\"testdir\\test1\\test2\").mkdirs(): " + new File("testdir\\test1\\test2").mkdirs());
		
		try {
			File f2 = new File("temp.txt");
			System.out.println("f2.createNewFile(): " + f2.createNewFile());
			System.out.println("f2.renameTo(...): " + f2.renameTo(new File("testdir\\temp1.txt"))); // move!!
		} catch (IOException e) {
			}
		}
		
	public static void main(String[] args) {
		// applyEncoding();
		fileMethodDemo();
	}
}
