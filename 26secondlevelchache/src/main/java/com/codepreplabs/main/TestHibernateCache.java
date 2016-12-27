package com.codepreplabs.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.codepreplabs.entity.Department;
import com.codepreplabs.util.HibernateUtil;


public class TestHibernateCache {

	public static void main(String[] args) {
		
		SessionFactory factory = HibernateUtil.getSessionfactory();
		Session session1 = factory.openSession();
		session1.beginTransaction();
		
		session1.get(Department.class, 1);
		session1.getTransaction().commit();
		session1.close();
		
		Session session2 = factory.openSession();
		session2.beginTransaction();
		
		session2.get(Department.class, 1);
		session2.getTransaction().commit();
		session2.close();
		
	}

}
