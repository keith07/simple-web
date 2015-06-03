package edu.keith.mvc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import edu.keith.mvc.bean.UserBean;

@Entity
@Table(name="user_info")
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
	
	@Id  
    @GeneratedValue(strategy = GenerationType.AUTO) 
	private String sid;
	@Column(name="user_name")
	private String userName;
	@Column(name="user_pass")
	private String userPass;
//	@Column(name="is_actived")
//	@org.hibernate.annotations.Type(type="yes_no")
	private boolean isActived;
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
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
