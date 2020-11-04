package com.codepreplabs.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.codepreplabs.util.HibernateUtil;


public class TestHibernateCache {

	public static void main(String[] args) {
		
		SessionFactory factory = HibernateUtil.getSessionfactory();
		Session session1 = factory.openSession();
		session1.beginTransaction();
		
		Query<String> query1 = session1.createQuery("SELECT departmentName FROM Department WHERE departmentName = :departmentName",
				String.class);
		query1.setParameter("departmentName", "Computer Science");
		query1.setHint("org.hibernate.cacheable", true);
		List<String> firstNames1 = query1.getResultList();
		session1.close();
		
		Session session2 = factory.openSession();
		session2.beginTransaction();
		
		Query<String> query2 = session2.createQuery("SELECT departmentName FROM Department WHERE departmentName = :departmentName",
				String.class);
		query2.setParameter("departmentName", "Computer Science");
		query2.setHint("org.hibernate.cacheable", true);
		List<String> firstNames2 = query2.getResultList();
		session2.getTransaction().commit();
		session2.close();
		factory.close();
	}

}
