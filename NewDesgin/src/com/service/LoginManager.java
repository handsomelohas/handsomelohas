package com.service;

import com.dao.ILoginDao;
import com.domain.Users;

public class LoginManager implements ILoginManager {
	
	private ILoginDao loginDao;
	
	public void setLoginDao(ILoginDao loginDao) {
		this.loginDao = loginDao;
	}

	public ILoginDao getLoginDao() {
		return loginDao;
	}

	@Override
	public Users checkUsers(Users u) {
		// TODO 自动生成的方法存根
		return loginDao.checkUsers(u);
	}

}
