package com.codepreplabs.main;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.codepreplabs.entity.Employee;
import com.codepreplabs.entity.EmployeeCredentials;

public class TestHibernate {

	public static void main(String[] args) {

		Employee employee = new Employee();
		employee.setFirstName("Harry");
		employee.setLastname("Potter");
		employee.setDateOfBirth(new Date());
		
		EmployeeCredentials credentials = new EmployeeCredentials();
		credentials.setEmail("harry@hogworth.com");
		credentials.setUsername("harry");
		credentials.setPassword("magicwand@");
		
		employee.setCredentials(credentials);

		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(employee);
		session.save(credentials);
		session.getTransaction().commit();
		session.close();


	}

}
