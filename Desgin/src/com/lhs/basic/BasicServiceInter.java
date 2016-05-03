package com.lhs.basic;

import java.util.List;

public interface BasicServiceInter {
	
	//�������÷���
	//1.ͨ��id��ȡ����
	public Object findById(Class clazz,java.io.Serializable id);
	//2.��ѯ����hql
	public List executeQuery(String hql,Object []parameters);
	//��ѯ��������ҳ
	public List executeQueryByPage(String hql,Object []parameters,int pageNow,int pageSize);
	//4.���һ������
	public void add(Object obj);
	//ͳһ��ִ��hql����ɾ�����޸�hql="update domain���� where ?"
	public List executeUpdate(String hql,Object []parameters);
	//6.����һ������Ĳ���
	public Object uniqueQuery(String hql,Object []parameters);
	//7.�õ�HQL������pageCout
	public int queryPageCount(String hql,Object []parameters,int pageSize);
	//8.����idɾ��
	public void delById(Class clazz,java.io.Serializable id);
	//ͨ��Object�޸Ĺ�Ա
	public void update(Object object);
	
}
