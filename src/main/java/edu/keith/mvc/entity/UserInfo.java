package edu.keith.mvc.entity;

import java.io.Serializable;

import edu.keith.mvc.bean.UserBean;

public class UserInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UserInfo(){
		super();
	}
	
	public UserInfo(UserBean _user){
		this.setUserName(_user.getUserName());
		this.setUserPass(_user.getUserPass());
		this.setActived(true);
	}
	
	private int sid;
	private String userName;
	private String userPass;
	private boolean isActived;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	public boolean isActived() {
		return isActived;
	}
	public void setActived(boolean isActived) {
		this.isActived = isActived;
	}
	
	public String toString(){
		return "sid:"+sid+" userName"+userName+" userPass"+userPass+" isActived"+isActived;
	}
}
