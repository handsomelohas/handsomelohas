package com.lhs.service.impl;

import java.util.List;

import com.lhs.basic.BasicService;
import com.lhs.domain.Users;
import com.lhs.service.inter.LoginServiceInter;
import com.lhs.struts.action.MD5Util;

public class LoginService extends BasicService implements LoginServiceInter {

	public Users checkUsers(Users u) {
		// TODO Auto-generated method stub
		String hql="from Users where userId=? and password=? and role=?";
		Object []parameters ={u.getUserId(),MD5Util.string2MD5(u.getPassword()),u.getRole()};
		List list=this.executeQuery(hql, parameters);
		if(list.size()==0){
			return null;
		}else{
			return (Users) list.get(0);
		}
	}

}
