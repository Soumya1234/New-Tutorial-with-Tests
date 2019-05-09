package com.udemy.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IODemo2 {
	public static void main(String[] args) {
		File source = new File("C:");
		/*
		 * File dest = new File("E:\\testdir\\destDir"); try { copy(source,dest); }
		 * catch (IOException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
		
		String[] dirs = source.list();
		for(String d:dirs) {
			System.out.println(d);
		}
		
	}

	//copies the source file to the destDir directory
	private static void copy(File source, File destDir) throws IOException {
		if (!source.isFile() || !source.exists()) {
			throw new IOException("source file does not exist");
		}
		if (!destDir.isDirectory() || !destDir.exists()) {
			throw new IOException("destination directory does not exist");
		}
		FileInputStream src = new FileInputStream(source);
		try (BufferedInputStream in = new BufferedInputStream(src);
				BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(destDir+File.separator+source.getName()))) {
			byte[] buf = new byte[8000];
			int noOfBytesRead;
			while ((noOfBytesRead = in.read(buf, 0, buf.length)) != -1) {
				out.write(buf);
			}
			
		}
	}
}
