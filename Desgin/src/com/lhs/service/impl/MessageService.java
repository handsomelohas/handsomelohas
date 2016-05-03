package com.lhs.service.impl;

import java.util.List;

import com.lhs.basic.BasicService;
import com.lhs.domain.Message;
import com.lhs.domain.Users;
import com.lhs.service.inter.MessageServiceInter;


public class MessageService extends BasicService implements MessageServiceInter{

	public List<Message> showMessage(Users user) {
		// TODO Auto-generated method stub
		String hql="from Message where getter.userId=?";
		String parameters[]={user.getUserId()};
		List<Message> message=this.executeQuery(hql, parameters);
		return message;
	}

	public Users getUserByName(String username) {
		// TODO Auto-generated method stub
		String hql="from Users where userName=?";
		String parameters[]={username};
		Users user=null;
		try {
			user=(Users) this.uniqueQuery(hql, parameters);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e.getMessage());
		}
				
		return user;
	}


}
