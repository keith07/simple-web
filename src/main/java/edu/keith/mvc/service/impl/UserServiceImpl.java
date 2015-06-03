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

	@Override
	public UserInfo regist(UserBean user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserInfo login(String userName, String userPass) {
		// TODO Auto-generated method stub
		List<UserInfo> ui = dao.findAll();
		System.out.println(ui.size());
		return null;
	}
}
