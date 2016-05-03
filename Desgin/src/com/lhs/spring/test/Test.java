package com.lhs.spring.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		SessionFactory sf=(SessionFactory) ac.getBean("sessionFactory");
		
		Session s=sf.openSession();
//		Admin admin=new Admin("LH888","Αυ»ͺΛΎ","200869","3");
		
		Transaction tx=s.beginTransaction();
//		s.save(admin);
		tx.commit();
		
	}

}
