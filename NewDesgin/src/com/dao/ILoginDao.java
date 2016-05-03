package com.dao;

import com.basic.IBasicDao;
import com.domain.Users;

public interface ILoginDao extends IBasicDao{
	public Users checkUsers(Users u);
}
