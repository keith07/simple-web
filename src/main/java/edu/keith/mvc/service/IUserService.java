package edu.keith.mvc.service;

import edu.keith.mvc.bean.UserBean;
import edu.keith.mvc.entity.UserInfo;

public interface IUserService {

	/**
	 * 注册
	 * @param user
	 * @return
	 */
	public UserInfo regist(UserBean user);
	/**
	 * 登录
	 * @param userName
	 * @param userPass
	 * @return
	 */
	public UserInfo login(String userName,String userPass);
	/**
	 * 用户名校验
	 * @param userName
	 * @return
	 */
	public boolean isNameExisted(String userName);

	void testSaveOrUpdate();
}
