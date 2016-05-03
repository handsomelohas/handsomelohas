package com.lhs.service.inter;

import java.util.List;

import com.lhs.basic.BasicServiceInter;

public interface UserServiceInter extends BasicServiceInter{
	
	//show
		 public List showUsersList(int pageSize,int pageNow);
		 
		 public int getPageCount(int pageSize);
}
