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

	//*****************����Ĳ���***************************
	//��ת�����ѽ���
	public ActionForward goPublishMessage(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String id=request.getParameter("id");
	    Task t=(Task) messageService.findById(Task.class, Integer.parseInt(id));
	   
	    request.setAttribute("task", t);
		return mapping.findForward("goPublishMessage");
	}
	//������Ϣ�Ĳ���
	public ActionForward PublishMessage(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		//��ȡ��
		MessageForm messageForm=(MessageForm) form;
		//����Message����
		Message message=new Message();
		message.setContent(messageForm.getContent());
		//��ȡ�û��Ķ���
		message.setGetter(messageService.getUserByName(messageForm.getGetter()));//��Ҫһ��������ȡ�û��Ķ���
		message.setMesTime(new Date());
		message.setSender((Users) request.getSession().getAttribute("loginuser"));
		//����Ҳ����,��ΪmessageServiceInter��userServiceInter
		//���̳���Base
		messageService.add(message);
		return mapping.findForward("addok2");
	}
	//��ת����ʾ��Ϣ����
	public ActionForward goShowManMessage(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		//ȡ����ǰ�û�
		Users loginUser=(Users) request.getSession().getAttribute("loginuser");
		List<Message> list=messageService.showMessage(loginUser);
		//list���Ϸ���request
		request.setAttribute("messageList", list);
		
		return mapping.findForward("goShowManMessage");
	}
	//****************ְ������**************************
	//��ת����ʾ��Ϣ����
	public ActionForward goShowEmpMessage(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		//ȡ����ǰ�û�
		Users loginUser=(Users) request.getSession().getAttribute("loginuser");
		List<Message> list=messageService.showMessage(loginUser);
		//list���Ϸ���request
		request.setAttribute("messageList", list);
		
		return mapping.findForward("goShowEmpMessage");
	}
	//ְ���ظ�����
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
	//������Ϣ�Ĳ���
	public ActionForward ReplyMessage(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		//��ȡ��
		MessageForm messageForm=(MessageForm) form;
		//����Message����
		Message message=new Message();
		message.setContent(messageForm.getContent());
		//��ȡ�û��Ķ���
		message.setGetter(messageService.getUserByName(messageForm.getGetter()));//��Ҫһ��������ȡ�û��Ķ���
		message.setMesTime(new Date());
		message.setSender((Users) request.getSession().getAttribute("loginuser"));
		messageService.add(message);
		//�������message����
		return mapping.findForward("addok3");
	}
	
}
