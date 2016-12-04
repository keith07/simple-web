package edu.keith.mvc.dao;

import java.util.List;

import edu.keith.mvc.entity.UserInfo;

public interface UserDao{
	public UserInfo get(int sid);
	
	public List<UserInfo> findByName(String userName);
	
	public int save(UserInfo user);
}
