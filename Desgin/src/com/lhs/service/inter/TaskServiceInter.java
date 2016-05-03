package com.lhs.service.inter;

import java.util.List;

import com.lhs.basic.BasicServiceInter;

public interface TaskServiceInter extends BasicServiceInter{
		
	 //显示所有任务
	 public List showTaskList(int pageSize,int pageNow);
	 
	 public int getPageCount(int pageSize);
	 
	 //带条件的查询分页
	 public int getPageCount1(String fenId,int pageSize);
	 
	 //显示查询任务
	 public List showTaskList1(String taskId,int pageSize, int pageNow);
	 
	 //显示经理要分配的任务信息
	 public List showTaskList2(String fenId,int pageSize, int pageNow);
	 //取出经理手下的职工
	 public List showTaskList3(String role,String deport);
	 //显示已经分配任务的信息
	 public List showFenTaskList(String fenId,int pageSize, int pageNow);
	 
	 //带条件的查询分页
	 public int getPageCount2(String fenId,int pageSize);
	//显示任务已经完成要评价的信息
    public List showAudTask(String fenId,int pageSize, int pageNow);
    
    public int getPageCountAudTask(String fenId,int pageSize);
	
	//************************职工**********************
	public List showEmpTaskList(String emploeeId,int pageSize, int pageNow);
	
	public int getPageCount3(String emploeeId,int pageSize);
	
	//显示该职工的部门所有任务信息
/*	public List showDeportTaskList(String fenId,int pageSize, int pageNow);
	
	public int getPageCount4(String fenId,int pageSize);
	*/
	//显示职工每天要提交任务
	public List showSubmitTask(String emploeeId,int pageSize, int pageNow);
	
	public int getPageCount5(String emploeeId,int pageSize);
	//显示职工已经完成任务
	public List showSubmitFinshTask(String emploeeId,int pageSize, int pageNow);
	
	public int getPageCount6(String emploeeId,int pageSize);
	
	//显示职工已评价的信息
	public List showEmpAudTask(String emploeeId,int pageSize, int pageNow);
	
	public int getPageCount7(String emploeeId,int pageSize);
}
