package com.lhs.service.impl;

import java.util.List;

import com.lhs.basic.BasicService;
import com.lhs.service.inter.TaskServiceInter;

public class TaskService extends BasicService implements TaskServiceInter {
	//显示所有任务
	public List showTaskList(int pageSize, int pageNow) {
		// TODO Auto-generated method stub
		String hql="from Task order by id";
		return this.executeQueryByPage(hql, null, pageSize, pageNow);
	}

	public int getPageCount(int pageSize) {
		// TODO Auto-generated method stub
		String hql="select count(*) from Task";
		
		return this.queryPageCount(hql, null, pageSize);
	}
	//带条件的查询分页
	public int getPageCount1(String fenId,int pageSize) {
		// TODO Auto-generated method stub
		String hql="select count(*) from Task where type='未分配' and fenId=?";
		Object []parameters ={fenId};
		return this.queryPageCount(hql, parameters, pageSize);
	}
	//显示查询任务
	public List showTaskList1(String taskId,int pageSize, int pageNow) {
		// TODO Auto-generated method stub
		String hql="from Task where taskId=? order by id";
		Object []parameters ={taskId};
		return this.executeQueryByPage(hql, parameters, pageSize, pageNow);
	}
	//显示经理要分配的任务信息
	public List showTaskList2(String fenId,int pageSize, int pageNow) {
		// TODO Auto-generated method stub
		String hql="from Task where type='未分配' and fenId=? order by id";
		Object []parameters ={fenId};
		return this.executeQueryByPage(hql, parameters, pageSize, pageNow);
	}
	//取出经理手下的职工
	public List showTaskList3(String role,String deport) {
		// TODO Auto-generated method stub
		String hql="from Users where role=? and deport=?";
		Object []parameters ={role,deport};
		return this.executeQuery(hql, parameters);
	}
	//显示已经分配任务的信息
	public List showFenTaskList(String fenId,int pageSize, int pageNow) {
		// TODO Auto-generated method stub
		String hql="from Task where (type='分配' or type='开始' or type='进行中') and fenId=? order by id";
		Object []parameters ={fenId};
		return this.executeQueryByPage(hql,parameters, pageSize, pageNow);
	}
	//带条件的查询分页
	public int getPageCount2(String fenId,int pageSize) {
		// TODO Auto-generated method stub
		String hql="select count(*) from Task where (type='分配' or type='开始' or type='进行中') and fenId=?";
		Object []parameters ={fenId};
		return this.queryPageCount(hql, parameters, pageSize);
	}
	//显示任务已经完成要评价的信息
	public List showAudTask(String fenId,int pageSize, int pageNow) {
		// TODO Auto-generated method stub
		String hql="from Task where type='完成' and fenId=? order by id";
		Object []parameters ={fenId};
		return this.executeQueryByPage(hql,parameters, pageSize, pageNow);
	}
	//带条件的查询分页
	public int getPageCountAudTask(String fenId,int pageSize) {
		// TODO Auto-generated method stub
		String hql="select count(*) from Task where type='完成' and fenId=?";
		Object []parameters ={fenId};
		return this.queryPageCount(hql, parameters, pageSize);
	}
	//************************职工**********************
	//显示已经分配任务的信息
	public List showEmpTaskList(String emploeeId,int pageSize, int pageNow) {
		// TODO Auto-generated method stub
		String hql="from Task where type='分配' and emploeeId=? order by id";
		Object []parameters ={emploeeId};
		return this.executeQueryByPage(hql,parameters, pageSize, pageNow);
	}
	//带条件的查询分页
	public int getPageCount3(String emploeeId,int pageSize) {
		// TODO Auto-generated method stub
		String hql="select count(*) from Task where type='分配' and emploeeId=?";
		Object []parameters ={emploeeId};
		return this.queryPageCount(hql, parameters, pageSize);
	}
	//显示该职工的部门所有任务信息
	/*public List showDeportTaskList(String fenId,int pageSize, int pageNow) {
		// TODO Auto-generated method stub
		String hql="from Task where fenId=? order by id";
		Object []parameters ={fenId};
		return this.executeQueryByPage(hql,parameters, pageSize, pageNow);
	}
	//带条件的查询分页
	public int getPageCount4(String fenId,int pageSize) {
		// TODO Auto-generated method stub
		String hql="select count(*) from Task where fenId=?";
		Object []parameters ={fenId};
		return this.queryPageCount(hql, parameters, pageSize);
	}*/
	//显示职工每天要提交任务
	public List showSubmitTask(String emploeeId,int pageSize, int pageNow) {
		// TODO Auto-generated method stub
		String hql="from Task where (type='开始' or type='进行中') and emploeeId=? order by id";
		Object []parameters ={emploeeId};
		return this.executeQueryByPage(hql,parameters, pageSize, pageNow);
	}
	//带条件的查询分页
	public int getPageCount5(String emploeeId,int pageSize) {
		// TODO Auto-generated method stub
		String hql="select count(*) from Task where (type='开始' or type='进行中') and emploeeId=?";
		Object []parameters ={emploeeId};
		return this.queryPageCount(hql, parameters, pageSize);
	}
	
	//显示职工已经完成任务
	public List showSubmitFinshTask(String emploeeId,int pageSize, int pageNow) {
		// TODO Auto-generated method stub
		String hql="from Task where type='完成' and emploeeId=? order by id";
		Object []parameters ={emploeeId};
		return this.executeQueryByPage(hql,parameters, pageSize, pageNow);
	}
	//带条件的查询分页
	public int getPageCount6(String emploeeId,int pageSize) {
		// TODO Auto-generated method stub
		String hql="select count(*) from Task where type='完成' and emploeeId=?";
		Object []parameters ={emploeeId};
		return this.queryPageCount(hql, parameters, pageSize);
	}
	//显示职工已评价的信息
	public List showEmpAudTask(String emploeeId,int pageSize, int pageNow) {
		// TODO Auto-generated method stub
		String hql="from Task where audtype='已评' and emploeeId=? order by id";
		Object []parameters ={emploeeId};
		return this.executeQueryByPage(hql,parameters, pageSize, pageNow);
	}
	//带条件的查询分页
	public int getPageCount7(String emploeeId,int pageSize) {
		// TODO Auto-generated method stub
		String hql="select count(*) from Task where audtype='已评' and emploeeId=?";
		Object []parameters ={emploeeId};
		return this.queryPageCount(hql, parameters, pageSize);
	}
}
