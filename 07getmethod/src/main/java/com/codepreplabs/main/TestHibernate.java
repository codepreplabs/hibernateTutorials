package com.codepreplabs.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.codepreplabs.entity.Employee;

public class TestHibernate {

	public static void main(String[] args) {

		Employee employee = new Employee();
		employee.setEmployeeId(10);
		employee.setFirstName("CodePrep");
		employee.setLastname("labs");

		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(employee);
		session.getTransaction().commit();
		session.close();
		
		Session session2 = sessionFactory.openSession();
		session2.beginTransaction();
		Employee employee2 = (Employee) session2.get(Employee.class, 10);
		session2.getTransaction().commit();
		
		System.out.println("The first name of the employee is: "+employee2.getFirstName());
		

	}

}
