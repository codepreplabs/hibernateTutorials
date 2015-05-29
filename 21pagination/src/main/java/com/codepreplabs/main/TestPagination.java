package com.codepreplabs.main;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.codepreplabs.util.HibernateUtil;

public class TestPagination {

	public static void main(String[] args) {

		try {

			SessionFactory sessionFactory = HibernateUtil.getSessionfactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			Query query = session.createQuery("SELECT firstName FROM Employee");

			query.setFirstResult(2);
			query.setMaxResults(3);

			List<String> firstNames = query.list();
			for (String firstname : firstNames)
				System.out.println(firstname);

			session.getTransaction().commit();
			session.close();
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}

}
