package com.dao;
import java.util.List;

import com.basic.BasicDao;
import com.domain.Users;

public class LoginDao extends BasicDao implements ILoginDao{

	@Override
	public Users checkUsers(Users u) {
		// TODO 自动生成的方法存根
		String hql="from Users where userId=? and password=? and role=?";
		Object []parameters ={u.getUserId(),com.controller.MD5Util.string2MD5(u.getPassword()),u.getRole()};
		List list=this.executeQuery(hql, parameters);
		if(list.size()==0){
			return null;
		}else{
			return (Users) list.get(0);
		}
	}
	
}
