package com.codepreplabs.main;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.codepreplabs.util.HibernateUtil;

public class TestHibernate {

	public static void main(String[] args) {

		String firstName = "Jessica";

		SessionFactory sessionFactory = HibernateUtil.getSessionfactory();
		
		
		try (Session session = sessionFactory.openSession()) {

			session.beginTransaction();
			Query query = session.createQuery("SELECT firstName FROM Employee WHERE firstName = ?1");

			query.setParameter(1, firstName);

			List<String> firstNames = query.list();
			for (String firstname : firstNames)
				System.out.println(firstname);

			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try (Session session = sessionFactory.openSession()){

			session.beginTransaction();
			Query<String> query = session.createQuery("SELECT firstName FROM Employee WHERE firstName = :firstName",
					String.class);

			query.setParameter("firstName", firstName);

			List<String> firstNames = query.getResultList();
			for (String firstname : firstNames)
				System.out.println(firstname);

			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
