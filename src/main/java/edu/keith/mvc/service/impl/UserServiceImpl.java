package edu.keith.mvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.keith.mvc.bean.UserBean;
import edu.keith.mvc.dao.UserDao;
import edu.keith.mvc.entity.UserInfo;
import edu.keith.mvc.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserDao dao;

	public UserInfo regist(UserBean userBean) {
		// TODO Auto-generated method stub
		if(isNameExisted(userBean.getUserName()))
			return null;
		return dao.save(new UserInfo(userBean));
	}

	public UserInfo login(String userName, String userPass) {
		List<UserInfo> list = dao.findByName(userName);
		if(list.size() < 1 || !list.get(0).getUserPass().equals(userPass))
			return null;
		return list.get(0);
	}

	public boolean isNameExisted(String userName) {
		if(userName == null || "".equals(userName.trim()))
			return false;
		List<UserInfo> user = dao.findByName(userName);
		return user.size() > 0;
	}
}
