package com.service;

import java.util.List;

import com.dao.IUsersDao;
import com.domain.Users;

public class UsersManager implements IUsersManager {
	
	private IUsersDao usersDao;
	
	public void setUsersDao(IUsersDao usersDao) {
		this.usersDao = usersDao;
	}

	public void setUserDao(IUsersDao usersDao) {
		this.usersDao = usersDao;
	}

	@Override
	public void addUser(Users users) {
		// TODO 自动生成的方法存根
		usersDao.addUser(users);
	}

	@Override
	public List<Users> getAllUser(int pageSize,int pageNow) {
		// TODO 自动生成的方法存根
		return usersDao.getAllUser(pageSize,pageNow);
	}

	@Override
	public boolean delUser(String id) {
		// TODO 自动生成的方法存根
		return usersDao.delUser(id);
	}

}
