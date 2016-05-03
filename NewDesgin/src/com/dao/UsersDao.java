package com.dao;

import java.util.List;

import com.basic.BasicDao;
import com.domain.Users;

public class UsersDao extends BasicDao implements IUsersDao {

	@Override
	public void addUser(Users users) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public List getAllUser(int pageSize,int pageNow) {
		// TODO 自动生成的方法存根
		String hql="from Users order by id";
		return this.executeQueryByPage(hql, null, pageSize, pageNow);
	}

	@Override
	public boolean delUser(String id) {
		// TODO 自动生成的方法存根
		return false;
	}

}
