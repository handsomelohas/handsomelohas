package com.lhs.service.inter;

import com.lhs.basic.BasicServiceInter;
import com.lhs.domain.Users;

public interface LoginServiceInter extends BasicServiceInter{
	public Users checkUsers(Users u);
}
