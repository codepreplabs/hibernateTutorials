package com.codepreplabs.main;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.codepreplabs.entity.Employee;
import com.codepreplabs.util.HibernateUtil;

public class TestHQL {

	private static SessionFactory sessionFactory = HibernateUtil
			.getSessionfactory();

	public static void main(String[] args) {

		// selectAll();

		// whereClause();

		// innerJoin();
	}

	/**
	 * Select all query using HQL.
	 */
	public static void selectAll() {

		Session session = sessionFactory.openSession();
		Query query = session.createQuery("FROM Employee");

		List<Employee> employees = query.list();
		for (Employee employee : employees) {
			System.out.println(employee.getEmployeeId());
			System.out.println(employee.getFirstName());
			System.out.println(employee.getLastname());
			System.out.println(employee.getDepartment().getDepartmentName());
		}

		session.close();

	}

	public static void whereClause() {

		Session session = sessionFactory.openSession();
		Query query = session.createQuery("FROM Employee WHERE employeeId=2");

		List<Employee> employees = query.list();
		for (Employee employee : employees) {
			System.out.println(employee.getEmployeeId());
			System.out.println(employee.getFirstName());
			System.out.println(employee.getLastname());
			System.out.println(employee.getDepartment().getDepartmentName());
		}

		session.close();
	}

	public static void innerJoin() {

		Session session = sessionFactory.openSession();
		Query query = session
				.createQuery("SELECT D.departmentName, E.firstName, E.lastname FROM Employee E, Department D WHERE D.department_Id = E.department");

		List<Object> result = (List<Object>) query.list();
		Iterator itr = result.iterator();
		
		while(itr.hasNext()){
			Object[] obj = (Object[]) itr.next();
			String client = String.valueOf(obj[0]);
			System.out.println(client);
			client = String.valueOf(obj[1]);
			System.out.println(client);
		}

		session.close();
	}
}
