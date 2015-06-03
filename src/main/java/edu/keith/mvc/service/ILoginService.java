package edu.keith.mvc.service;

import edu.keith.mvc.bean.UserBean;

public interface ILoginService extends IService {
	
	public boolean regist(UserBean user);
	public boolean login(UserBean user);

}
