package edu.keith.demo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class OutterInner {

	private String outerName="Outer";
	private int outerAge;
	private List<Boolean> bs;
	public OutterInner(int age){
		outerAge = age;
		bs = new ArrayList<Boolean>();
		bs.add(true);
		bs.add(false);
	}
	
	public boolean getRandom(){
		return new Inner().getRandom();
	}
	
	class Inner{
		public boolean getRandom(){
			return bs.isEmpty() ? true : bs.get(0);
		}
	}
	
	class Outer implements Serializable{
		public boolean isMe(boolean b){
			return false;
		}
	}
}
