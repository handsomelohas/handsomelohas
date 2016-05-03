package com.lhs.basic;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public abstract class BasicService implements BasicServiceInter {
	
	@Resource
	private SessionFactory sessionFactory;
	
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Object findById(Class clazz, Serializable id) {
		// TODO Auto-generated method stub
		
		return this.sessionFactory.getCurrentSession().get(clazz, id);
	}
	
	//ͳһ��ѯ����
	public List executeQuery(String hql, Object[] parameters) {
		// TODO Auto-generated method stub
		
		Query query=this.sessionFactory.getCurrentSession().createQuery(hql);
		//ע�룿ֵ
		if(parameters!=null && parameters.length>0){
			for(int i=0;i<parameters.length;i++){
				query.setParameter(i, parameters[i]);
			}
		}
		
		return query.list();
	}
	
	//��ҳ
	public List executeQueryByPage(String hql, Object[] parameters, int pageNow,
			int pageSize) {
		// TODO Auto-generated method stub
		Query query=this.sessionFactory.getCurrentSession().createQuery(hql);
		
		if(parameters!=null && parameters.length>0){
			for(int i=0;i<parameters.length;i++){
				query.setParameter(i, parameters[i]);
			}
		}
		//���ַ�ҳ
		return query.setFirstResult((pageNow-1)*pageSize).setMaxResults(pageSize).list();
		
	}
	
	//ͳһ��ӷ���
	public void add(Object obj) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().save(obj);
	}
	
	//ͳһ���޸ģ�ɾ��
	public List executeUpdate(String hql, Object[] parameters) {
		// TODO Auto-generated method stub
		return null;
	}

	//6.����һ������Ĳ���
	public Object uniqueQuery(String hql,Object []parameters){
		
		Query query=this.sessionFactory.getCurrentSession().createQuery(hql);
		
		if(parameters!=null && parameters.length>0){
			for(int i=0;i<parameters.length;i++){
				query.setParameter(i, parameters[i]);
			}
		}
		return query.uniqueResult();
	}
	
	//7
	public int queryPageCount(String hql,Object []parameters,int pageSize){
		//��ȡrowCount
		Object obj=this.uniqueQuery(hql, parameters);
//		Integer rowCount=new Integer(obj+"");
		int rowCount=Integer.parseInt(obj.toString());
		
		return (rowCount-1)/pageSize+1;
	}
	//8
	public void delById(Class clazz,Serializable id){
		
		Session session=this.sessionFactory.getCurrentSession();
		session.delete(this.findById(clazz, id));
		
	}
	//9
	public void update(Object object){
		this.sessionFactory.getCurrentSession().update(object);
	}
	
}
