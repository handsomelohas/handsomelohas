package com.lhs.basic;

import java.util.List;

public interface BasicServiceInter {
	
	//声明常用方法
	//1.通过id获取对象
	public Object findById(Class clazz,java.io.Serializable id);
	//2.查询方法hql
	public List executeQuery(String hql,Object []parameters);
	//查询方法带分页
	public List executeQueryByPage(String hql,Object []parameters,int pageNow,int pageSize);
	//4.添加一个对象
	public void add(Object obj);
	//统一的执行hql》》删除，修改hql="update domain对象 where ?"
	public List executeUpdate(String hql,Object []parameters);
	//6.返回一个对象的操作
	public Object uniqueQuery(String hql,Object []parameters);
	//7.得到HQL，返回pageCout
	public int queryPageCount(String hql,Object []parameters,int pageSize);
	//8.根据id删除
	public void delById(Class clazz,java.io.Serializable id);
	//通过Object修改雇员
	public void update(Object object);
	
}
