package com.lhs.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.lhs.domain.Users;
import com.lhs.service.inter.EmployeeServiceInter;
import com.lhs.struts.form.UsersForm;


public class EmployeeAction extends DispatchAction {
	
	private EmployeeServiceInter employeeService;
	
	public void setEmployeeService(EmployeeServiceInter employeeService) {
		this.employeeService = employeeService;
	}

	
	public ActionForward addEmpUi(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		return mapping.findForward("goAddEmp");
	}
	//处理添加雇员
	public ActionForward addEmp(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stu b
		UsersForm usersForm=(UsersForm) form;
		Users users=new Users();
		
		users.setUserId(usersForm.getUserId());
		users.setPassword(MD5Util.string2MD5(usersForm.getPassword()));
		System.out.println("********:"+MD5Util.string2MD5(usersForm.getPassword()));
		users.setUserName(usersForm.getUserName());
		users.setSex(usersForm.getSex());
		users.setAge(usersForm.getAge());
		users.setIndate(usersForm.getIndate());
		users.setPosition(usersForm.getPosition());
		users.setDeport(usersForm.getDeport());
		users.setRole(usersForm.getRole());
		
		try {
			employeeService.add(users);
		} catch (Exception e) {
			// TODO: handle exception
			return mapping.findForward("adderr1");
		}
		
		
		return mapping.findForward("addok1");
	}
	//显示用户信息
	public ActionForward showEmp(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		String s_pageNow=request.getParameter("pageNow");
		int pageNow=1;
		if(s_pageNow!=null){
			pageNow=Integer.parseInt(s_pageNow);
		}
		request.setAttribute("emplist", employeeService.showEmployeeList(pageNow,10));
//		request.setAttribute("emplist", employeeService.showEmployeeList1(role,pageNow,3));
		int pageCount=employeeService.getPageCount(10);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("pageNow", pageNow);
		
		return mapping.findForward("goShowEmp");
	}
	
	//删除用户
	public ActionForward delEmp(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
	    String userId=request.getParameter("userId");
	    
	    try {
	    	employeeService.delById(Users.class, userId);
		} catch (Exception e) {
			// TODO: handle exception
			return mapping.findForward("adderr1");
		}
	    
		return mapping.findForward("addok1");
	}
	//updateEmp
	public ActionForward goupdateEmp(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
	    String userId=request.getParameter("userId");
	    
	    Users e=(Users) employeeService.findById(Users.class,userId);
	    
	    request.setAttribute("emp", e);
	    
		return mapping.findForward("goUpdateEmp");
	}
	//更新雇员updateEmp
	public ActionForward updateEmp(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
	    //获取表单
		UsersForm usersForm=(UsersForm) form;
		Users users=new Users();
		users.setUserId(usersForm.getUserId());
		users.setPassword(usersForm.getPassword());
		users.setUserName(usersForm.getUserName());
		users.setSex(usersForm.getSex());
		users.setAge(usersForm.getAge());
		users.setIndate(usersForm.getIndate());
		users.setPosition(usersForm.getPosition());
		users.setDeport(usersForm.getDeport());
		users.setRole(usersForm.getRole());
	    
	    try {
			employeeService.update(users);
		} catch (Exception e) {
			// TODO: handle exception
			return mapping.findForward("adderr1");
		}
	    
		return mapping.findForward("addok1");
	}
	
	//用户查询显示
	public ActionForward showEmp1(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		UsersForm usersForm=(UsersForm) form;
		
		String userId=usersForm.getUserId();
		String s_pageNow=request.getParameter("pageNow");
		int pageNow=1;
		if(s_pageNow!=null){
			pageNow=Integer.parseInt(s_pageNow);
		}
		request.setAttribute("emplist", employeeService.showEmployeeList2(userId,pageNow,10));
		int pageCount=employeeService.getPageCount(10);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("pageNow", pageNow);
		
		return mapping.findForward("goShowEmp");
	}
		//显示经理下面有多少职工
	public ActionForward showEmp2(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String userId=request.getParameter("userId");
		Users users=(Users) employeeService.findById(Users.class, userId);
		String deport =users.getDeport();
		String s_pageNow=request.getParameter("pageNow");
		int pageNow=1;
		if(s_pageNow!=null){
			pageNow=Integer.parseInt(s_pageNow);
		}
		request.setAttribute("emplist", employeeService.showEmployeeList3(deport, pageNow, 10));
//			request.setAttribute("emplist", employeeService.showEmployeeList1(role,pageNow,3));
		int pageCount=employeeService.getPageCount2(deport, 10);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("pageNow", pageNow);
		
		return mapping.findForward("goShowEmp2");
	}
	
	//经理查询职工显示
	public ActionForward showQEmp2(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		UsersForm usersForm=(UsersForm) form;
		
		String userId=usersForm.getUserId();
		String s_pageNow=request.getParameter("pageNow");
		int pageNow=1;
		if(s_pageNow!=null){
			pageNow=Integer.parseInt(s_pageNow);
		}
		request.setAttribute("emplist", employeeService.showEmployeeList2(userId,pageNow,10));
		int pageCount=employeeService.getPageCount(10);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("pageNow", pageNow);
		
		return mapping.findForward("goShowEmp2");
	}
		//******************职工的操作*******************************
		//职工跳转到职工个人信息页面
	public ActionForward goEmpUi(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String userId=request.getParameter("userId");
		request.setAttribute("emplist",employeeService.findById(Users.class, userId));
		
		return mapping.findForward("goEmpUi");
	}
	
}
