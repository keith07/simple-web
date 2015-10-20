package edu.keith.mvc.controller;

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
	public String doLogin(String userName,String userPass, Map<String,Object> model){
		UserInfo user = service.login(userName, userPass);
		if(user == null || !user.isActived()){
			model.put("userName", userName);
			model.put("errorMsg", "用户名密码不匹配！");
			return "/index/login";
		}
		return "redirect:/main/index";
	}
	
	@RequestMapping("/login")
	public String toLogin(){
		return "/index/login";
	}
	
	@RequestMapping("/regist")
	public String regist(){
		return "/index/regist";
	}
	
	@RequestMapping("/index")
	public String index(){
		return "/index/index";
	}
	
	@RequestMapping("/doRegist")
	public String doRegist(UserBean userBean, Map<String,Object> model){
		if(userBean.getUserPass() == null || userBean.getConfirmPass() == null || !userBean.getUserPass().equals(userBean.getConfirmPass()))
			return "/index/regist";
		UserInfo user = service.regist(userBean);
		return user == null ? "/index/regist" : "redirect:/main/index";
	}
	
//	private void testConn(){
//		Connection connection = null;
//		try {
//			Class.forName("org.logicalcobwebs.proxool.ProxoolDriver");
//			connection = DriverManager.getConnection("proxool.xml-test");
//		} catch (Exception e) {
//			System.err.println(e);
//		}finally{
//			try {
//				connection.close();
//			} catch (SQLException e) {
//				if(connection != null)
//					connection = null;
//			}
//		}
//		System.out.println("ok");
//	}

}
