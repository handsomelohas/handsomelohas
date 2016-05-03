package com.lhs.struts.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.lhs.domain.Message;
import com.lhs.domain.Task;
import com.lhs.domain.Users;
import com.lhs.service.inter.EmployeeServiceInter;
import com.lhs.service.inter.MessageServiceInter;
import com.lhs.struts.form.MessageForm;

public class MessageAtion extends DispatchAction {
	
	private MessageServiceInter messageService;
	
	public void setMessageService(MessageServiceInter messageService) {
		this.messageService = messageService;
	}

	//*****************经理的操作***************************
	//跳转到提醒界面
	public ActionForward goPublishMessage(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String id=request.getParameter("id");
	    Task t=(Task) messageService.findById(Task.class, Integer.parseInt(id));
	   
	    request.setAttribute("task", t);
		return mapping.findForward("goPublishMessage");
	}
	//提醒信息的操作
	public ActionForward PublishMessage(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		//获取表单
		MessageForm messageForm=(MessageForm) form;
		//创建Message对象
		Message message=new Message();
		message.setContent(messageForm.getContent());
		//获取用户的对象
		message.setGetter(messageService.getUserByName(messageForm.getGetter()));//需要一个方法获取用户的对象
		message.setMesTime(new Date());
		message.setSender((Users) request.getSession().getAttribute("loginuser"));
		//这种也可以,因为messageServiceInter，userServiceInter
		//都继承了Base
		messageService.add(message);
		return mapping.findForward("addok2");
	}
	//跳转到显示信息界面
	public ActionForward goShowManMessage(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		//取出当前用户
		Users loginUser=(Users) request.getSession().getAttribute("loginuser");
		List<Message> list=messageService.showMessage(loginUser);
		//list集合放入request
		request.setAttribute("messageList", list);
		
		return mapping.findForward("goShowManMessage");
	}
	//****************职工操作**************************
	//跳转到显示信息界面
	public ActionForward goShowEmpMessage(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		//取出当前用户
		Users loginUser=(Users) request.getSession().getAttribute("loginuser");
		List<Message> list=messageService.showMessage(loginUser);
		//list集合放入request
		request.setAttribute("messageList", list);
		
		return mapping.findForward("goShowEmpMessage");
	}
	//职工回复经理
	public ActionForward goReplyMessage(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
	   String mesId=request.getParameter("mesId");
	   Message message=(Message) messageService.findById(Message.class, Integer.parseInt(mesId));
	   String userId=message.getSender().getUserId().toString();
	   Users users=(Users) messageService.findById(Users.class, userId);
	   String userName=users.getUserName().toString();
	    request.setAttribute("userName", userName);
		return mapping.findForward("goReplyMessage");
	}
	//提醒信息的操作
	public ActionForward ReplyMessage(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		//获取表单
		MessageForm messageForm=(MessageForm) form;
		//创建Message对象
		Message message=new Message();
		message.setContent(messageForm.getContent());
		//获取用户的对象
		message.setGetter(messageService.getUserByName(messageForm.getGetter()));//需要一个方法获取用户的对象
		message.setMesTime(new Date());
		message.setSender((Users) request.getSession().getAttribute("loginuser"));
		messageService.add(message);
		//保存的是message对象
		return mapping.findForward("addok3");
	}
	
}
