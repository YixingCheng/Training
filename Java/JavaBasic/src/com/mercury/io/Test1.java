package com.mercury.io;

import java.io.FileOutputStream;
import java.io.IOException;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1,2,3,4,5};
		//FileOutputStream fos = null;   //local variable has to be initialized
		//try with resource
		// all resource implements Autoclosable
		//FileOutputStream fos;
		try (FileOutputStream fos = new FileOutputStream("test1.dat")){   
			for (int x:array){
				fos.write(x);
			}
			
		} catch (IOException e){
			System.err.println(e);
		} 
		//finally{
		//	try{
		//		fos.close();
		//	} catch (Exception e){
		//		System.err.println(e);
		//	}
		// }
		System.out.println("End of main.");
	}

}
