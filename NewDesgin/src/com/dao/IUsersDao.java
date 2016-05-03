package com.dao;

import java.util.List;

import com.basic.IBasicDao;
import com.domain.Users;

public interface IUsersDao extends IBasicDao{
	public void addUser(Users users);
	
	public List<Users> getAllUser(int pageSize,int pageNow);
	
	public boolean delUser(String id);
	
	
}
