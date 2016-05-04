package com.mercury.io;

import java.io.*;

public class Test3 {
	public static void main(String[] args){
		try(FileOutputStream fos = new FileOutputStream("test3.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			Data data = new Data(1234567, 3.1415926, true);
			oos.writeObject(data);
		} catch(IOException e){
			System.err.println(e);
		}
		System.out.println("End of Main");
	}
}
