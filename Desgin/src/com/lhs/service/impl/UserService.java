package com.lhs.service.impl;

import java.util.List;

import com.lhs.basic.BasicService;
import com.lhs.service.inter.UserServiceInter;

public class UserService extends BasicService implements UserServiceInter {

	public List showUsersList(int pageSize, int pageNow) {
		// TODO Auto-generated method stub
		String hql="from Users order by id";
		return this.executeQueryByPage(hql, null, pageSize, pageNow);
	}

	public int getPageCount(int pageSize) {
		// TODO Auto-generated method stub
		String hql="select count(*) from Users";
		return this.queryPageCount(hql, null, pageSize);
	}

	

}
