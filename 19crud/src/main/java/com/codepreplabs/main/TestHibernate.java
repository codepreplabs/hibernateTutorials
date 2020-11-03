package com.codepreplabs.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.codepreplabs.entity.Employee;

public class TestHibernate {

	public static void main(String[] args) {

		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Employee employee1 = new Employee();
		employee1.setFirstName("Harry");
		employee1.setLastname("Potter");

		Employee employee2 = new Employee();
		employee2.setFirstName("Robin");
		employee2.setLastname("hood");

		
		 // Saving an object using the save() method 
		 session.save(employee1);
		 session.save(employee2);
		 

		// Retrieving object using get() method
//		Employee employee3 = (Employee) session.get(Employee.class, 1);
//		System.out.println(employee3);
		
		// Deleting rows using session.delete() method	
//		employee1.setEmployeeId(1);
//		session.delete(employee1);
		
		//updating rows using update or saveOrUpdate()
//		employee2.setEmployeeId(2);
//		employee2.setLastname("Updated");
//		session.update(employee2);
		
		
		session.getTransaction().commit();
		session.close();

//		System.out.println("Fetching the value from the database--> Firstname: "+employee2.getFirstName()+" lastname: "+employee2.getLastname());

	}

}
