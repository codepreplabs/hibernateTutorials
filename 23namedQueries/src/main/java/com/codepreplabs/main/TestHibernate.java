package com.codepreplabs.main;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.codepreplabs.entity.Employee;
import com.codepreplabs.util.HibernateUtil;

public class TestHibernate {

	public static void main(String[] args) {

//		namedHQLQuery();

		namedNativeSQLQuery();
	}

	/**
	 * example for a named HQL query.
	 */
	@SuppressWarnings("unchecked")
	public static void namedHQLQuery() {

		String firstName = "Jessica";
		SessionFactory sessionFactory = HibernateUtil.getSessionfactory();

		try (Session session = sessionFactory.openSession()) {
			session.beginTransaction();

			Query<Employee> query = session.getNamedQuery("Employee.byFirstName");

			query.setParameter("firstName", firstName);

			List<Employee> employees = query.getResultList();
			for (Employee employee : employees)
				System.out.println(employee.getFirstName());

			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * example for Named native sql query.
	 */
	@SuppressWarnings({ "unchecked" })
	public static void namedNativeSQLQuery() {

		String lastName = "shaw";
		try {

			SessionFactory sessionFactory = HibernateUtil.getSessionfactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();

			Query<Employee> query = session.getNamedQuery("Employee.byLastName");

			query.setParameter(1, lastName);

			List<Employee> employees = query.getResultList();
			for (Employee employee : employees)
				System.out.println(employee.getFirstName());

			session.getTransaction().commit();
			session.close();
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}

	}

}
