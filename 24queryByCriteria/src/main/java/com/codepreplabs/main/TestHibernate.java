package com.codepreplabs.main;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.codepreplabs.entity.Employee;
import com.codepreplabs.util.HibernateUtil;

public class TestHibernate {

	public static void main(String[] args) {

		namedHQLQuery();

		namedNativeSQLQuery();
	}

	/**
	 * example for a named HQL query.
	 */
	public static void namedHQLQuery() {

		String firstName = "Jessica";
		try {

			SessionFactory sessionFactory = HibernateUtil.getSessionfactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();

			Query query = session.getNamedQuery("Employee.byFirstName");

			query.setString("firstName", firstName);

			List<Employee> employees = query.list();
			for (Employee employee : employees)
				System.out.println(employee.getFirstName());

			session.getTransaction().commit();
			session.close();
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * example for Named native sql query.
	 */
	public static void namedNativeSQLQuery() {

		String lastName = "shaw";
		try {

			SessionFactory sessionFactory = HibernateUtil.getSessionfactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();

			Query query = session.getNamedQuery("Employee.byLastName");

			query.setString(0, lastName);

			List<Employee> employees = query.list();
			for (Employee employee : employees)
				System.out.println(employee.getFirstName());

			session.getTransaction().commit();
			session.close();
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}

	}

}
