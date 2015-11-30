package edu.keith.mvc.controller;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import edu.keith.mvc.bean.UserBean;
import edu.keith.mvc.entity.UserInfo;
import edu.keith.mvc.service.IUserService;

@Controller
@RequestMapping("/main")
public class BasicController {
	
	@Resource
	IUserService service;
	
	@RequestMapping("/doLogin")
	public String doLogin(String userName,String userPass){
		UserInfo user = service.login(userName, userPass);
		if(user == null || !user.isActived())
			return "/index/login";
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
		return "/index/bui";
	}
	
	@RequestMapping("/doRegist")
	public String doRegist(UserBean userBean, Map<String,Object> model,HttpServletRequest request){
		if(userBean.getUserPass() == null || userBean.getConfirmPass() == null || !userBean.getUserPass().equals(userBean.getConfirmPass()))
			return "/index/regist";
		UserInfo user = service.regist(userBean);
		if(user.getSid() <= 0)
			return "/index/regist";
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile sourceFile =  multipartRequest.getFile("pic");
		File localFile = new File("d:/files/user/"+user.getSid()+"/pic");
		localFile.mkdirs();
		try {
			sourceFile.transferTo(localFile);
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/main/index";
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
