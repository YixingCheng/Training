package com.mercury.code;

public class KeyMaster {

	public int k;
	public KeyMaster(int k){
		this.k = k;
	}
	public int hashCode(){
		return k;
	}
	public boolean equals(Object obj){
		return k==((KeyMaster) obj).k;
	}
}
