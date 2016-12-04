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
	
	public Goods(String value){
		this.sid = Integer.valueOf(value.substring(value.indexOf("sid")+"sid".length()+1,value.indexOf("&", value.indexOf("sid"))));
		this.keyWord = value.substring(value.indexOf("keyWord")+"keyWord".length()+1,value.indexOf("&", value.indexOf("keyWord")));
		this.name = value.substring(value.indexOf("name")+"name".length()+1,value.indexOf("&", value.indexOf("name")));
		this.selfDescribe = value.substring(value.indexOf("selfDescribe")+"selfDescribe".length()+1);
	}
	
	public Goods(){}
	
	public String toString(){
		StringBuilder sb = new StringBuilder("sid:");
		sb.append(sid).append("&keyWord:").append(keyWord).append("&name:").append(name).append("&selfDescribe:").append(selfDescribe);
		return sb.toString();
	}
}
