package edu.keith.mvc.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.keith.mvc.bean.UserBean;
import edu.keith.mvc.entity.UserInfo;
import edu.keith.mvc.service.IUserService;

@Controller
@RequestMapping("/main")
public class BasicController {
	
	@Resource
	IUserService service;
	
	@RequestMapping("/doLogin")
	public String doLogin(){
		System.out.println("I'm here");
		return "index/index";
	}
	
	@RequestMapping("/login")
	public String toLogin(){
		return "index/login";
	}
	
	@RequestMapping("/regist")
	public String regist(){
		return "index/regist";
	}
	
	@RequestMapping("/doRegist")
	public String doRegist(String userName,String userPass,String userPass2, Map<String,Object> model){
		System.out.println("I'm doRegist ing...");
		//TODO
		if(userPass == null || userPass2 == null || !userPass.equals(userPass2))
			return "index/regist";
//		UserBean user = new UserBean();
//		user.setUserName(userName);
//		user.setUserPass(userPass);
		testConn();
		UserInfo user = service.login(userName, userPass);
		return user == null ? "index/login" : "index/regist";
	}
	
	private void testConn(){
		Connection connection = null;
		try {
			Class.forName("org.logicalcobwebs.proxool.ProxoolDriver");
			connection = DriverManager.getConnection("proxool.xml-test");
		} catch (Exception e) {
			System.err.println(e);
		}finally{
			try {
				connection.close();
			} catch (SQLException e) {
				if(connection != null)
					connection = null;
			}
		}
		System.out.println("ok");
	}

}
