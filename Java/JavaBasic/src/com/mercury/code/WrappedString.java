package com.mercury.code;

public class WrappedString {
	private String str;
	
	public WrappedString(String str){
		this.str = str;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}
	
	@Override
	public int hashCode(){
		//return 10;
		return str.hashCode();
		/**
		 *  case 1: return a random number between 1 and 100
		 *  case 2: return 100;
		 */
	}
	
	@Override
	public boolean equals(Object obj){
		if(!(obj instanceof WrappedString)) return false;  //it's good to judge before casting
		WrappedString ws = (WrappedString) obj;
		return str.equals(ws.str);
		//return str.equals(obj.str)   obj cannot look down
		/**
		 * case 1: return true;
		 * case 2: return false;
		 */
	}

}
