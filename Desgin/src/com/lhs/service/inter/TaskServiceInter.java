package com.lhs.service.inter;

import java.util.List;

import com.lhs.basic.BasicServiceInter;

public interface TaskServiceInter extends BasicServiceInter{
		
	 //��ʾ��������
	 public List showTaskList(int pageSize,int pageNow);
	 
	 public int getPageCount(int pageSize);
	 
	 //�������Ĳ�ѯ��ҳ
	 public int getPageCount1(String fenId,int pageSize);
	 
	 //��ʾ��ѯ����
	 public List showTaskList1(String taskId,int pageSize, int pageNow);
	 
	 //��ʾ����Ҫ�����������Ϣ
	 public List showTaskList2(String fenId,int pageSize, int pageNow);
	 //ȡ���������µ�ְ��
	 public List showTaskList3(String role,String deport);
	 //��ʾ�Ѿ������������Ϣ
	 public List showFenTaskList(String fenId,int pageSize, int pageNow);
	 
	 //�������Ĳ�ѯ��ҳ
	 public int getPageCount2(String fenId,int pageSize);
	//��ʾ�����Ѿ����Ҫ���۵���Ϣ
    public List showAudTask(String fenId,int pageSize, int pageNow);
    
    public int getPageCountAudTask(String fenId,int pageSize);
	
	//************************ְ��**********************
	public List showEmpTaskList(String emploeeId,int pageSize, int pageNow);
	
	public int getPageCount3(String emploeeId,int pageSize);
	
	//��ʾ��ְ���Ĳ�������������Ϣ
/*	public List showDeportTaskList(String fenId,int pageSize, int pageNow);
	
	public int getPageCount4(String fenId,int pageSize);
	*/
	//��ʾְ��ÿ��Ҫ�ύ����
	public List showSubmitTask(String emploeeId,int pageSize, int pageNow);
	
	public int getPageCount5(String emploeeId,int pageSize);
	//��ʾְ���Ѿ��������
	public List showSubmitFinshTask(String emploeeId,int pageSize, int pageNow);
	
	public int getPageCount6(String emploeeId,int pageSize);
	
	//��ʾְ�������۵���Ϣ
	public List showEmpAudTask(String emploeeId,int pageSize, int pageNow);
	
	public int getPageCount7(String emploeeId,int pageSize);
}
