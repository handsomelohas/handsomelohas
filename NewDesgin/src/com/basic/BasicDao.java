package com.basic;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

public class BasicDao implements IBasicDao {
	
	@Resource
	private SessionFactory sessionFactory;
	
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public Object findById(Class clazz, Serializable id) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public List executeQuery(String hql, Object[] parameters) {
		
		Query query=this.sessionFactory.getCurrentSession().createQuery(hql);
		if(parameters!=null && parameters.length>0){
			for(int i=0;i<parameters.length;i++){
				query.setParameter(i, parameters[i]);
			}
		}
		return query.list();
	}

	@Override
	public List executeQueryByPage(String hql, Object[] parameters,
			int pageNow, int pageSize) {
		Query query=this.sessionFactory.getCurrentSession().createQuery(hql);
		
		if(parameters!=null && parameters.length>0){
			for(int i=0;i<parameters.length;i++){
				query.setParameter(i, parameters[i]);
			}
		}
		return query.setFirstResult((pageNow-1)*pageSize).setMaxResults(pageSize).list();
		
	}

	@Override
	public void add(Object obj) {
		// TODO 自动生成的方法存根

	}

	@Override
	public List executeUpdate(String hql, Object[] parameters) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public Object uniqueQuery(String hql, Object[] parameters) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public int queryPageCount(String hql, Object[] parameters, int pageSize) {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public void delById(Class clazz, Serializable id) {
		// TODO 自动生成的方法存根

	}

	@Override
	public void update(Object object) {
		// TODO 自动生成的方法存根

	}

}
