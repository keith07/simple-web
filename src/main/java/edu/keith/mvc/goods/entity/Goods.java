package edu.keith.mvc.goods.entity;

import java.io.Serializable;

public class Goods implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int sid;
	private String keyWord;
	private String name;
	private String selfDescribe;
	
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSelfDescribe() {
		return selfDescribe;
	}
	public void setSelfDescribe(String selfDescribe) {
		this.selfDescribe = selfDescribe;
	}
}
