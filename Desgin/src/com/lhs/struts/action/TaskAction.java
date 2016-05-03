package com.lhs.struts.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.lhs.domain.Task;
import com.lhs.domain.Users;
import com.lhs.service.inter.TaskServiceInter;
import com.lhs.struts.form.TaskForm;

public class TaskAction extends DispatchAction {
	
	private TaskServiceInter taskService;
	public void setTaskService(TaskServiceInter taskService) {
		this.taskService = taskService;
	}


	public ActionForward addTaskUi(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		request.setAttribute("role2", 
				taskService.executeQuery("from Users where role=2", null));
		
		return mapping.findForward("goAddTask");
	}
	//********************管理员处理添加任务********************
	public ActionForward addTask(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stu b
		
		TaskForm taskForm=(TaskForm) form;
		Task task=new Task();
		task.setTaskId(taskForm.getTaskId());
		task.setTaskName(taskForm.getTaskName());
		task.setContent(taskForm.getContent());
		task.setFounderId(taskForm.getFounderId());
		task.setFounder(taskForm.getFounder());
		task.setFenId(taskForm.getFenId());
		task.setFener(taskForm.getFener());
		task.setStartTime(taskForm.getStartTime());
		task.setEndTme(taskForm.getEndTme());
		task.setGrade(taskForm.getGrade());
		task.setType(taskForm.getType());
		
		try {
			taskService.add(task);
		} catch (Exception e) {
			// TODO: handle exception
			return mapping.findForward("adderr1");
		}
		
		return mapping.findForward("addok1");
	}
	//显示任务信息
	public ActionForward showTask(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String s_pageNow=request.getParameter("pageNow");
		int pageNow=1;
		if(s_pageNow!=null){
			pageNow=Integer.parseInt(s_pageNow);
		}
		request.setAttribute("tasklist", taskService.showTaskList(pageNow,10));
		int pageCount=taskService.getPageCount(10);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("pageNow", pageNow);
		
		
        return mapping.findForward("goShowTask");
		
	}
	
	//**********************管理员任务信息的公示任务查询显示****************************
	public ActionForward showQTask(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		TaskForm taskForm=(TaskForm) form;
		String taskId=taskForm.getTaskId();
		
		String s_pageNow=request.getParameter("pageNow");
		int pageNow=1;
		if(s_pageNow!=null){
			pageNow=Integer.parseInt(s_pageNow);
		}
		request.setAttribute("tasklist", taskService.showTaskList1(taskId,pageNow,10));
		int pageCount=taskService.getPageCount(10);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("pageNow", pageNow);
		
		
        return mapping.findForward("goShowTask");
		
	}
	
	//删除任务
	public ActionForward delTask(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
	    String id=request.getParameter("id");
	    
	    try {
	    	taskService.delById(Task.class, Integer.parseInt(id));
		} catch (Exception e) {
			// TODO: handle exception
			return mapping.findForward("adderr");
		}
	    
		return mapping.findForward("addok");
	}
	//updateTask
	public ActionForward goupdateTask(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
	    String id=request.getParameter("id");
	    
	    Task t=(Task) taskService.findById(Task.class, Integer.parseInt(id));
	    request.setAttribute("task", t);
	    
		return mapping.findForward("goUpdateTask");
	}
	//更新雇员updateTask
	public ActionForward updateTask(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
	    //获取表单
		TaskForm tf=(TaskForm) form;
		//ef>>domain
		Task task=new Task();
		task.setId(tf.getId());
		task.setTaskId(tf.getTaskId());
		task.setTaskName(tf.getTaskName());
		task.setContent(tf.getContent());
		task.setFounderId(tf.getFounderId());
		task.setFounder(tf.getFounder());
		task.setEmploeeId(tf.getEmploeeId());
		task.setEmployeeName(tf.getEmployeeName());
		task.setStartTime(tf.getStartTime());
		task.setEndTme(tf.getEndTme());
		task.setGrade(tf.getGrade());
	    try {
	    	taskService.update(task);
		} catch (Exception e) {
			// TODO: handle exception
			return mapping.findForward("adderr1");
		}
	    
		return mapping.findForward("addok1");
	}
	
	
	//**********************************经理操作*****************************
	//*********************显示经理要分配的任务信息*******************************
	
	public ActionForward showTask1(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String fenId=request.getParameter("userId");
		String s_pageNow=request.getParameter("pageNow");
		int pageNow=1;
		if(s_pageNow!=null){
			pageNow=Integer.parseInt(s_pageNow);
		}
		request.setAttribute("tasklist", taskService.showTaskList2(fenId, pageNow, 10));
		int pageCount=taskService.getPageCount1(fenId,10);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("pageNow", pageNow);
		
		
        return mapping.findForward("goST1Ui");
		
	}
	//************************经理的任务信息任务查询显示*****************************
	public ActionForward showQTask1(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		TaskForm taskForm=(TaskForm) form;
		String taskId=taskForm.getTaskId();
		String fenId=request.getParameter("userId");
		
		String s_pageNow=request.getParameter("pageNow");
		int pageNow=1;
		if(s_pageNow!=null){
			pageNow=Integer.parseInt(s_pageNow);
		}
		request.setAttribute("tasklist", taskService.showTaskList1(taskId,pageNow,10));
		int pageCount=taskService.getPageCount1(fenId,10);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("pageNow", pageNow);
		
        return mapping.findForward("goST1Ui");		
	}
	//************************分配任务************************************
	//跳转到分配页面
	public ActionForward goFenTask(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
	    String id=request.getParameter("id");
	    String userId=request.getParameter("userId");
	    Task t=(Task) taskService.findById(Task.class, Integer.parseInt(id));
	    Users u=(Users) taskService.findById(Users.class, userId);
	    String deport=u.getDeport().toString();
	    request.setAttribute("task", t);
	    String role="3";
	    request.setAttribute("role3", 
				taskService.showTaskList3(role, deport));
		return mapping.findForward("goFenTask");
	}
	//经理分配任务
	public ActionForward fenTask(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
	    //获取表单
		TaskForm tf=(TaskForm) form;
		//ef>>domain
		String id=request.getParameter("id");
	    Task task= (Task) taskService.findById(Task.class, Integer.parseInt(id));
	    task.setEmploeeId(tf.getEmploeeId());
	    task.setEmployeeName(tf.getEmployeeName());
	    task.setFenTime(tf.getFenTime());
	    task.setType(tf.getType());
	    task.setPercentage("0%");
	    try {
	    	taskService.update(task);
		} catch (Exception e) {
			// TODO: handle exception
			return mapping.findForward("adderr2");
		}
	    
		return mapping.findForward("addok2");
	}
	
	//分配任务显示
	public ActionForward showFenTask(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String s_pageNow=request.getParameter("pageNow");
		String fenId=request.getParameter("userId");
		int pageNow=1;
		if(s_pageNow!=null){
			pageNow=Integer.parseInt(s_pageNow);
		}
		request.setAttribute("tasklist", taskService.showFenTaskList(fenId,pageNow, 10));
		int pageCount=taskService.getPageCount2(fenId,10);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("pageNow", pageNow);
		
		
        return mapping.findForward("goShowFenTask");
		
	}
	//************************经理的任务信息任务查询显示*****************************
		public ActionForward showQFenTask(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response) throws Exception {
			// TODO Auto-generated method stub
			String userId=request.getParameter("uersId");
			TaskForm taskForm=(TaskForm) form;
			String taskId =taskForm.getTaskId();
			String s_pageNow=request.getParameter("pageNow");
			int pageNow=1;
			if(s_pageNow!=null){
				pageNow=Integer.parseInt(s_pageNow);
			}
			request.setAttribute("tasklist", taskService.showTaskList1(taskId,pageNow,10));
			int pageCount=taskService.getPageCount2(userId,10);
			request.setAttribute("pageCount", pageCount);
			request.setAttribute("pageNow", pageNow);
			
	        return mapping.findForward("goShowFenTask");		
		}
	//*****************任务信息跟踪显示*********************
		public ActionForward showLookTask(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response) throws Exception {
			// TODO Auto-generated method stub
			String fenId=request.getParameter("userId");
			String s_pageNow=request.getParameter("pageNow");
			int pageNow=1;
			if(s_pageNow!=null){
				pageNow=Integer.parseInt(s_pageNow);
			}
			request.setAttribute("tasklist", taskService.showFenTaskList(fenId, pageNow, 10));
			int pageCount=taskService.getPageCount2(fenId,10);
			request.setAttribute("pageCount", pageCount);
			request.setAttribute("pageNow", pageNow);
			
			
	        return mapping.findForward("goshowLookTask");
			
		}
		//************************经理的任务信息跟踪任务查询显示*****************************
		public ActionForward showQLookTask(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response) throws Exception {
			// TODO Auto-generated method stub
			TaskForm taskForm=(TaskForm) form;
			String taskId=taskForm.getTaskId();
			String fenId=request.getParameter("userId");
			
			String s_pageNow=request.getParameter("pageNow");
			int pageNow=1;
			if(s_pageNow!=null){
				pageNow=Integer.parseInt(s_pageNow);
			}
			request.setAttribute("tasklist", taskService.showTaskList1(taskId,pageNow,10));
			int pageCount=taskService.getPageCount1(fenId,10);
			request.setAttribute("pageCount", pageCount);
			request.setAttribute("pageNow", pageNow);
			
	        return mapping.findForward("goshowLookTask");		
		}
		//*****************显示任务完成评价信息*********************
		public ActionForward showAudTask(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response) throws Exception {
			// TODO Auto-generated method stub
			String fenId=request.getParameter("userId");
			String s_pageNow=request.getParameter("pageNow");
			int pageNow=1;
			if(s_pageNow!=null){
				pageNow=Integer.parseInt(s_pageNow);
			}
			request.setAttribute("tasklist", taskService.showAudTask(fenId, pageNow, 10));
			int pageCount=taskService.getPageCountAudTask(fenId,10);
			request.setAttribute("pageCount", pageCount);
			request.setAttribute("pageNow", pageNow);
			
			
	        return mapping.findForward("goshowAudTask");
						
		}
		//************************经理的任务信息评价任务查询显示*****************************
		public ActionForward showQAudTask(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response) throws Exception {
			// TODO Auto-generated method stub
			TaskForm taskForm=(TaskForm) form;
			String taskId=taskForm.getTaskId();
			String fenId=request.getParameter("userId");
			
			String s_pageNow=request.getParameter("pageNow");
			int pageNow=1;
			if(s_pageNow!=null){
				pageNow=Integer.parseInt(s_pageNow);
			}
			request.setAttribute("tasklist", taskService.showTaskList1(taskId,pageNow,10));
			int pageCount=taskService.getPageCount1(fenId,10);
			request.setAttribute("pageCount", pageCount);
			request.setAttribute("pageNow", pageNow);
			
	        return mapping.findForward("goshowAudTask");		
		}
		//跳转到评价页面
		public ActionForward goManagerAudTask(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response) throws Exception {
			// TODO Auto-generated method stub
		    String id=request.getParameter("id");
		    
		    Task t=(Task) taskService.findById(Task.class, Integer.parseInt(id));
		    
		    request.setAttribute("task", t);
		    
			return mapping.findForward("goManagerAudTask");
		}
		//评价页面
		public ActionForward ManagerAudTask(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response) throws Exception {
			// TODO Auto-generated method stub
		    //获取表单
			TaskForm tf=(TaskForm) form;
			//ef>>domain
			String id=request.getParameter("id");
			Task task=(Task) taskService.findById(Task.class, Integer.parseInt(id));
			
			task.setAudcontent(tf.getAudcontent());
			task.setGoal(tf.getGoal());
			task.setSatisfaction(tf.getSatisfaction());
			task.setAudtime(tf.getAudtime());
			task.setAudtype(tf.getAudtype());
		    try {
		    	taskService.update(task);
			} catch (Exception e) {
				// TODO: handle exception
				return mapping.findForward("adderr2");
			}
		    
			return mapping.findForward("addok2");
		}
		//********************职工操作**************************
		//显示个人任务
		public ActionForward showEmpTask(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response) throws Exception {
			// TODO Auto-generated method stub
			String emploeeId=request.getParameter("userId");
			String s_pageNow=request.getParameter("pageNow");
			int pageNow=1;
			if(s_pageNow!=null){
				pageNow=Integer.parseInt(s_pageNow);
			}
			request.setAttribute("tasklist", taskService.showEmpTaskList(emploeeId, pageNow, 10));
			int pageCount=taskService.getPageCount3(emploeeId,10);
			request.setAttribute("pageCount", pageCount);
			request.setAttribute("pageNow", pageNow);
			
			
	        return mapping.findForward("goshowEmpTask");
			
		}
		//显示个人任务查询
		public ActionForward showQEmpTask(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response) throws Exception {
			// TODO Auto-generated method stub
			TaskForm taskForm=(TaskForm) form;
			String taskId=taskForm.getTaskId();
			String emploeeId=request.getParameter("userId");
			
			String s_pageNow=request.getParameter("pageNow");
			int pageNow=1;
			if(s_pageNow!=null){
				pageNow=Integer.parseInt(s_pageNow);
			}
			request.setAttribute("tasklist", taskService.showTaskList1(taskId,pageNow,10));
			int pageCount=taskService.getPageCount3(emploeeId,10);
			request.setAttribute("pageCount", pageCount);
			request.setAttribute("pageNow", pageNow);
			
	        return mapping.findForward("goshowEmpTask");		
		}
		//跳转去任务修改任务的状态页面
		
		public ActionForward goEmpTaskType(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response) throws Exception {
			// TODO Auto-generated method stub
			
		    String id=request.getParameter("id");
		    Task t=(Task) taskService.findById(Task.class, Integer.parseInt(id));
		   
		    request.setAttribute("task", t);
		   
		    
			return mapping.findForward("goEmpTaskType");
		}
		
		//开始任务修改任务的状态
		public ActionForward empUpdateTaskType(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response) throws Exception {
			// TODO Auto-generated method stub
		    //获取表单
			TaskForm tf=(TaskForm) form;
			//ef>>domain
			String id=request.getParameter("id");
		    Task task= (Task) taskService.findById(Task.class, Integer.parseInt(id));
		    
		    task.setType(tf.getType());
		    try {
		    	taskService.update(task);
			} catch (Exception e) {
				// TODO: handle exception
				return mapping.findForward("adderr3");
			}
		    
			return mapping.findForward("addok3");
		}
		
		//显示职工每天要提交任务
		public ActionForward showSubmitTask(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response) throws Exception {
			// TODO Auto-generated method stub
			String emploeeId=request.getParameter("userId");
			String s_pageNow=request.getParameter("pageNow");
			int pageNow=1;
			if(s_pageNow!=null){
				pageNow=Integer.parseInt(s_pageNow);
			}
			request.setAttribute("tasklist", taskService.showSubmitTask(emploeeId, pageNow, 10));
			int pageCount=taskService.getPageCount5(emploeeId,10);
			request.setAttribute("pageCount", pageCount);
			request.setAttribute("pageNow", pageNow);
			
			
	        return mapping.findForward("goshowSubmitTask");
			
		}
		//显示每天要提交任务查询
		public ActionForward showQSubmitTask(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response) throws Exception {
			// TODO Auto-generated method stub
			TaskForm taskForm=(TaskForm) form;
			String taskId=taskForm.getTaskId();
			String emploeeId=request.getParameter("userId");
			
			String s_pageNow=request.getParameter("pageNow");
			int pageNow=1;
			if(s_pageNow!=null){
				pageNow=Integer.parseInt(s_pageNow);
			}
			request.setAttribute("tasklist", taskService.showTaskList1(taskId,pageNow,10));
			int pageCount=taskService.getPageCount3(emploeeId,10);
			request.setAttribute("pageCount", pageCount);
			request.setAttribute("pageNow", pageNow);
			
	        return mapping.findForward("goshowSubmitTask");		
		}
		
		//跳转去任务修改任务的完成度页面
		
		public ActionForward goEmpTaskPre(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response) throws Exception {
			// TODO Auto-generated method stub
			
		    String id=request.getParameter("id");
		    Task t=(Task) taskService.findById(Task.class, Integer.parseInt(id));
		   
		    request.setAttribute("task", t);
		   
		    
			return mapping.findForward("goEmpTaskPre");
		}
		
		//开始任务修改任务的状态
		public ActionForward empUpdateTaskPre(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response) throws Exception {
			// TODO Auto-generated method stub
		    //获取表单
			TaskForm tf=(TaskForm) form;
			//ef>>domain
			String id=request.getParameter("id");
		    Task task= (Task) taskService.findById(Task.class, Integer.parseInt(id));
		    
		    task.setPercentage(tf.getPercentage());
		    task.setType(tf.getType());
		    try {
		    	taskService.update(task);
			} catch (Exception e) {
				// TODO: handle exception
				return mapping.findForward("adderr3");
			}
		    
			return mapping.findForward("addok3");
		}
		//显示职工完成任务公示
		public ActionForward showSubmitFinshTask(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response) throws Exception {
			// TODO Auto-generated method stub
			String emploeeId=request.getParameter("userId");
			String s_pageNow=request.getParameter("pageNow");
			int pageNow=1;
			if(s_pageNow!=null){
				pageNow=Integer.parseInt(s_pageNow);
			}
			request.setAttribute("tasklist", taskService.showSubmitFinshTask(emploeeId, pageNow, 10));
			int pageCount=taskService.getPageCount6(emploeeId,10);
			request.setAttribute("pageCount", pageCount);
			request.setAttribute("pageNow", pageNow);
			
	        return mapping.findForward("goshowSubmitFinshTask");
			
		}
		//显示职工完成任务公示查询
		public ActionForward showQSubmitFinshTask(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response) throws Exception {
			// TODO Auto-generated method stub
			TaskForm taskForm=(TaskForm) form;
			String taskId=taskForm.getTaskId();
			String emploeeId=request.getParameter("userId");
			
			String s_pageNow=request.getParameter("pageNow");
			int pageNow=1;
			if(s_pageNow!=null){
				pageNow=Integer.parseInt(s_pageNow);
			}
			request.setAttribute("tasklist", taskService.showTaskList1(taskId,pageNow,10));
			int pageCount=taskService.getPageCount3(emploeeId,10);
			request.setAttribute("pageCount", pageCount);
			request.setAttribute("pageNow", pageNow);
			
	        return mapping.findForward("goshowSubmitFinshTask");		
		}
		//显示职工*****经理已评价的信息
		public ActionForward showEmpAudTask(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response) throws Exception {
			// TODO Auto-generated method stub
			String emploeeId=request.getParameter("userId");
			String s_pageNow=request.getParameter("pageNow");
			int pageNow=1;
			if(s_pageNow!=null){
				pageNow=Integer.parseInt(s_pageNow);
			}
			request.setAttribute("tasklist", taskService.showEmpAudTask(emploeeId, pageNow, 10));
			int pageCount=taskService.getPageCount7(emploeeId,10);
			request.setAttribute("pageCount", pageCount);
			request.setAttribute("pageNow", pageNow);
			
	        return mapping.findForward("goshowEmpAudTask");
			
		}
		//显示职工******经理评价任务查询
		public ActionForward showQEmpAudTask(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response) throws Exception {
			// TODO Auto-generated method stub
			TaskForm taskForm=(TaskForm) form;
			String taskId=taskForm.getTaskId();
			String emploeeId=request.getParameter("userId");
			
			String s_pageNow=request.getParameter("pageNow");
			int pageNow=1;
			if(s_pageNow!=null){
				pageNow=Integer.parseInt(s_pageNow);
			}
			request.setAttribute("tasklist", taskService.showTaskList1(taskId,pageNow,10));
			int pageCount=taskService.getPageCount3(emploeeId,10);
			request.setAttribute("pageCount", pageCount);
			request.setAttribute("pageNow", pageNow);
			
	        return mapping.findForward("goshowEmpAudTask");		
		}
 }
