package com.mercury.io;

import java.io.*;

public class Test2 {
	public static void main(String[] args){
		int x = 1234567;
		double d = 3.1315926;
		boolean b = true;
		try (FileOutputStream fos = new FileOutputStream("test2.dat");
			 BufferedOutputStream buffer = new BufferedOutputStream(fos);
			 DataOutputStream dos = new DataOutputStream(buffer)){
				 dos.writeInt(x);
				 dos.writeDouble(d);
				 dos.writeBoolean(b);
			 } catch(IOException e){
				 System.err.println(e);
			 }
		System.out.println("End of main.");
	}
}
