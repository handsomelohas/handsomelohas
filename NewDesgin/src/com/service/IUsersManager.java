package com.service;

import java.util.List;

import com.domain.Users;

public interface IUsersManager {
	
    public void addUser(Users users);
	
	public List<Users> getAllUser(int pageSize,int pageNow);
	
	public boolean delUser(String id);
}
