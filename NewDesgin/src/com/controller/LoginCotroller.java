package com.controller;

import javax.annotation.Resource;

import org.apache.catalina.mbeans.UserMBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.domain.Users;
import com.service.ILoginManager;

@Controller
@RequestMapping("/user")
public class LoginCotroller {
	
	@Resource(name="loginManager")
	private ILoginManager loginManager;
	
	@RequestMapping("/login")
	public String login(Users users){

		Users loginType = loginManager.checkUsers(users);
		String role = users.getRole();
		String url = "";
		
		if(loginType!=null&&role.equals("1")){
			url = "/WEB-INF/Jsp/admin";
		}else if (loginType!=null&&role.equals("2")){
			url = "/WEB-INF/Jsp/manager";
		}else if (loginType!=null&&role.equals("3")){
			url = "/WEB-INF/Jsp/employee";
		}else{
			url = "/WEB-INF/publicJsp/login";
		}
		
		return url;
	}
	
}
