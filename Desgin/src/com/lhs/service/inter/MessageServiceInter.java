package com.lhs.service.inter;

import java.util.List;

import com.lhs.basic.BasicServiceInter;
import com.lhs.domain.Message;
import com.lhs.domain.Users;

public interface MessageServiceInter extends BasicServiceInter{
	
	public List<Message> showMessage(Users user);

	public Users getUserByName(String getter);
	
}
