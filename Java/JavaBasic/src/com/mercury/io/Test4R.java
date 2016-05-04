package com.mercury.io;

import java.io.*;

public class Test4R {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(FileInputStream fis = new FileInputStream("test4.dat");
				 ObjectInputStream ois = new ObjectInputStream(fis)){
					 Login login = (Login) ois.readObject();
					 System.out.println("Integer: " + login.getUsername());
					 System.out.println("Double: " + login.getPassword());
				 } catch (IOException | ClassNotFoundException e) {
					 System.err.println(e.getMessage());
				 }
	}

}
