package com.lhs.service.impl;

import java.util.List;
import com.lhs.basic.BasicService;
import com.lhs.service.inter.EmployeeServiceInter;

public class EmployeeService extends BasicService implements EmployeeServiceInter {
	
	//��ʾ���ǹ���Ա�����й�Ա
	public List showEmployeeList(int pageSize,int pageNow){
		String hql="from Users where role=2 or role=3 order by userId";
		return this.executeQueryByPage(hql, null, pageSize, pageNow);
	}
	//��ʾȨ��Ϊְ����Ա
//	public List showEmployeeList1(String role,int pageSize,int pageNow){
//		String hql="from Users where role=? order by id";
//		Object []parameters ={role};
//		return this.executeQueryByPage(hql, parameters, pageSize, pageNow);
//	}
	
	public int getPageCount(int pageSize){
		
		String hql="select count(*) from Users";
		return this.queryPageCount(hql, null, pageSize);
	}
	//*************�û���ѯ��ʾ���**********
	public List showEmployeeList2(String userId, int pageSize, int pageNow) {
		// TODO Auto-generated method stub
		String hql="from Users where userId=? order by userId";
		Object []parameters ={userId};
		return this.executeQueryByPage(hql, parameters, pageSize, pageNow);
	}
	
	//***************��ʾ���������ж���ְ��********************
	public List showEmployeeList3(String deport, int pageSize, int pageNow) {
		// TODO Auto-generated method stub
		String hql="from Users where role=3 and deport=? order by userId";
		Object []parameters ={deport};
		return this.executeQueryByPage(hql, parameters, pageSize, pageNow);
	}
	public int getPageCount2(String deport, int pageSize){
		
		String hql="select count(*) from Users where role=3 and deport=?";
		Object []parameters ={deport};
		return this.queryPageCount(hql, parameters, pageSize);
	}
}
