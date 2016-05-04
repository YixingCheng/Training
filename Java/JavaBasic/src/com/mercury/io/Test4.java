package com.mercury.io;

import java.io.*;

public class Test4 {
	public static void main(String[] args){
		try(FileOutputStream fos = new FileOutputStream("test4.dat");
				ObjectOutputStream oos = new ObjectOutputStream(fos)) {
				Login login = new Login("alice", "12345");
				oos.writeObject(login);
			} catch(IOException e){
				System.err.println(e);
			}
			System.out.println("End of Main");
	}
}
