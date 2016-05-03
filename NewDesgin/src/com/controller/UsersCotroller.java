package com.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.domain.Users;
import com.service.IUsersManager;

@Controller
@RequestMapping("/user")
public class UsersCotroller {

	@Resource(name="usersManager")
	private IUsersManager usersManager;
	
	@RequestMapping("/getAllUsers")
	public Users getAllUsers(int pageSize, int pageNow){

		Users user = (Users) usersManager.getAllUser(pageSize, pageNow);
		
		return user;
	}
	
}
