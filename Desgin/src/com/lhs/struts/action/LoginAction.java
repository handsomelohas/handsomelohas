/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.lhs.struts.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.lhs.domain.Users;
import com.lhs.service.inter.LoginServiceInter;
import com.lhs.struts.form.UsersForm;

	
public class LoginAction extends DispatchAction {
	@Resource
	LoginServiceInter loginService;
	//验证用户登录
	public ActionForward login(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		UsersForm usersForm=(UsersForm) form;
		Users u=new Users();
		u.setUserId(usersForm.getUserId());
		u.setPassword(usersForm.getPassword());
		u.setRole(usersForm.getRole());
		
		u=loginService.checkUsers(u);
		String role=usersForm.getRole();
		
		if(u!=null&&role.equals("1")){
			
			request.getSession().setAttribute("loginuser", u);
			return mapping.findForward("admin");
			
		}else if(u!=null&&role.equals("2")){
			
			request.getSession().setAttribute("loginuser", u);
			return mapping.findForward("ok");
			
		}else if(u!=null&&role.equals("3")){
			
			request.getSession().setAttribute("loginuser", u);
			return mapping.findForward("ok1");
			
		}else{
			return mapping.findForward("err");
		}
	}
	//管理员修改密码
	public ActionForward goupdatepw(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		 
		 return mapping.findForward("gopwUi");
	}
	//管理员修改密码
	public ActionForward updatepassword(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		UsersForm usersForm=(UsersForm) form;
		String userId=request.getParameter("userId");
		Users users=(Users) loginService.findById(Users.class, userId);
		
		users.setPassword(usersForm.getPassword());
		
			try {
		    	loginService.update(users);
			} catch (Exception e) {
				// TODO: handle exception
				return mapping.findForward("adderr1");
			} 
				return mapping.findForward("addok1");
		
	}	
	//经理修改密码
	public ActionForward goupdatepw1(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		 
		 return mapping.findForward("gopwUi1");
	}
	//经理修改密码
	public ActionForward updatepassword1(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		UsersForm usersForm=(UsersForm) form;
		String userId=request.getParameter("userId");
		Users users=(Users) loginService.findById(Users.class, userId);
		
		users.setPassword(usersForm.getPassword());
		
			try {
		    	loginService.update(users);
			} catch (Exception e) {
				// TODO: handle exception
				return mapping.findForward("adderr2");
			} 
				return mapping.findForward("addok2");
		
	}	
	//职工修改密码
	public ActionForward goupdatepw2(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		 
		 return mapping.findForward("gopwUi2");
	}
	//职工修改密码
	public ActionForward updatepassword2(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		UsersForm usersForm=(UsersForm) form;
		String userId=request.getParameter("userId");
		Users users=(Users) loginService.findById(Users.class, userId);
		
		users.setPassword(usersForm.getPassword());
		
			try {
		    	loginService.update(users);
			} catch (Exception e) {
				// TODO: handle exception
				return mapping.findForward("adderr3");
			} 
				return mapping.findForward("addok3");
		
	}	
}