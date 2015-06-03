package edu.keith.mvc.service;

import edu.keith.mvc.bean.UserBean;
import edu.keith.mvc.entity.UserInfo;

public interface IUserService {

	public UserInfo regist(UserBean user);
	public UserInfo login(String userName,String userPass);
}
