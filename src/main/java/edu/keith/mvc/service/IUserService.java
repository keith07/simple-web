package edu.keith.mvc.service;

import edu.keith.mvc.bean.UserBean;
import edu.keith.mvc.entity.UserInfo;

public interface IUserService {

	/**
	 * ע��
	 * @param user
	 * @return
	 */
	public UserInfo regist(UserBean user);
	/**
	 * ��¼
	 * @param userName
	 * @param userPass
	 * @return
	 */
	public UserInfo login(String userName,String userPass);
	/**
	 * �û���У��
	 * @param userName
	 * @return
	 */
	public boolean isNameExisted(String userName);
}
