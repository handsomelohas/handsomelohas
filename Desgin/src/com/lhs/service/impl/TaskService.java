package com.lhs.service.impl;

import java.util.List;

import com.lhs.basic.BasicService;
import com.lhs.service.inter.TaskServiceInter;

public class TaskService extends BasicService implements TaskServiceInter {
	//��ʾ��������
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
	//�������Ĳ�ѯ��ҳ
	public int getPageCount1(String fenId,int pageSize) {
		// TODO Auto-generated method stub
		String hql="select count(*) from Task where type='δ����' and fenId=?";
		Object []parameters ={fenId};
		return this.queryPageCount(hql, parameters, pageSize);
	}
	//��ʾ��ѯ����
	public List showTaskList1(String taskId,int pageSize, int pageNow) {
		// TODO Auto-generated method stub
		String hql="from Task where taskId=? order by id";
		Object []parameters ={taskId};
		return this.executeQueryByPage(hql, parameters, pageSize, pageNow);
	}
	//��ʾ����Ҫ�����������Ϣ
	public List showTaskList2(String fenId,int pageSize, int pageNow) {
		// TODO Auto-generated method stub
		String hql="from Task where type='δ����' and fenId=? order by id";
		Object []parameters ={fenId};
		return this.executeQueryByPage(hql, parameters, pageSize, pageNow);
	}
	//ȡ���������µ�ְ��
	public List showTaskList3(String role,String deport) {
		// TODO Auto-generated method stub
		String hql="from Users where role=? and deport=?";
		Object []parameters ={role,deport};
		return this.executeQuery(hql, parameters);
	}
	//��ʾ�Ѿ������������Ϣ
	public List showFenTaskList(String fenId,int pageSize, int pageNow) {
		// TODO Auto-generated method stub
		String hql="from Task where (type='����' or type='��ʼ' or type='������') and fenId=? order by id";
		Object []parameters ={fenId};
		return this.executeQueryByPage(hql,parameters, pageSize, pageNow);
	}
	//�������Ĳ�ѯ��ҳ
	public int getPageCount2(String fenId,int pageSize) {
		// TODO Auto-generated method stub
		String hql="select count(*) from Task where (type='����' or type='��ʼ' or type='������') and fenId=?";
		Object []parameters ={fenId};
		return this.queryPageCount(hql, parameters, pageSize);
	}
	//��ʾ�����Ѿ����Ҫ���۵���Ϣ
	public List showAudTask(String fenId,int pageSize, int pageNow) {
		// TODO Auto-generated method stub
		String hql="from Task where type='���' and fenId=? order by id";
		Object []parameters ={fenId};
		return this.executeQueryByPage(hql,parameters, pageSize, pageNow);
	}
	//�������Ĳ�ѯ��ҳ
	public int getPageCountAudTask(String fenId,int pageSize) {
		// TODO Auto-generated method stub
		String hql="select count(*) from Task where type='���' and fenId=?";
		Object []parameters ={fenId};
		return this.queryPageCount(hql, parameters, pageSize);
	}
	//************************ְ��**********************
	//��ʾ�Ѿ������������Ϣ
	public List showEmpTaskList(String emploeeId,int pageSize, int pageNow) {
		// TODO Auto-generated method stub
		String hql="from Task where type='����' and emploeeId=? order by id";
		Object []parameters ={emploeeId};
		return this.executeQueryByPage(hql,parameters, pageSize, pageNow);
	}
	//�������Ĳ�ѯ��ҳ
	public int getPageCount3(String emploeeId,int pageSize) {
		// TODO Auto-generated method stub
		String hql="select count(*) from Task where type='����' and emploeeId=?";
		Object []parameters ={emploeeId};
		return this.queryPageCount(hql, parameters, pageSize);
	}
	//��ʾ��ְ���Ĳ�������������Ϣ
	/*public List showDeportTaskList(String fenId,int pageSize, int pageNow) {
		// TODO Auto-generated method stub
		String hql="from Task where fenId=? order by id";
		Object []parameters ={fenId};
		return this.executeQueryByPage(hql,parameters, pageSize, pageNow);
	}
	//�������Ĳ�ѯ��ҳ
	public int getPageCount4(String fenId,int pageSize) {
		// TODO Auto-generated method stub
		String hql="select count(*) from Task where fenId=?";
		Object []parameters ={fenId};
		return this.queryPageCount(hql, parameters, pageSize);
	}*/
	//��ʾְ��ÿ��Ҫ�ύ����
	public List showSubmitTask(String emploeeId,int pageSize, int pageNow) {
		// TODO Auto-generated method stub
		String hql="from Task where (type='��ʼ' or type='������') and emploeeId=? order by id";
		Object []parameters ={emploeeId};
		return this.executeQueryByPage(hql,parameters, pageSize, pageNow);
	}
	//�������Ĳ�ѯ��ҳ
	public int getPageCount5(String emploeeId,int pageSize) {
		// TODO Auto-generated method stub
		String hql="select count(*) from Task where (type='��ʼ' or type='������') and emploeeId=?";
		Object []parameters ={emploeeId};
		return this.queryPageCount(hql, parameters, pageSize);
	}
	
	//��ʾְ���Ѿ��������
	public List showSubmitFinshTask(String emploeeId,int pageSize, int pageNow) {
		// TODO Auto-generated method stub
		String hql="from Task where type='���' and emploeeId=? order by id";
		Object []parameters ={emploeeId};
		return this.executeQueryByPage(hql,parameters, pageSize, pageNow);
	}
	//�������Ĳ�ѯ��ҳ
	public int getPageCount6(String emploeeId,int pageSize) {
		// TODO Auto-generated method stub
		String hql="select count(*) from Task where type='���' and emploeeId=?";
		Object []parameters ={emploeeId};
		return this.queryPageCount(hql, parameters, pageSize);
	}
	//��ʾְ�������۵���Ϣ
	public List showEmpAudTask(String emploeeId,int pageSize, int pageNow) {
		// TODO Auto-generated method stub
		String hql="from Task where audtype='����' and emploeeId=? order by id";
		Object []parameters ={emploeeId};
		return this.executeQueryByPage(hql,parameters, pageSize, pageNow);
	}
	//�������Ĳ�ѯ��ҳ
	public int getPageCount7(String emploeeId,int pageSize) {
		// TODO Auto-generated method stub
		String hql="select count(*) from Task where audtype='����' and emploeeId=?";
		Object []parameters ={emploeeId};
		return this.queryPageCount(hql, parameters, pageSize);
	}
}
