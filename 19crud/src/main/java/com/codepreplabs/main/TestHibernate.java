package com.codepreplabs.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.codepreplabs.entity.Employee;

public class TestHibernate {

	public static void main(String[] args) {

		Employee employee = new Employee();
		employee.setFirstName("Harry");
		employee.setLastname("Potter");

		Employee employee1 = new Employee();
		employee1.setFirstName("Robin");
		employee1.setLastname("hood");

		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		
/*		 // Saving an object using the save() method 
		 session.save(employee);
		 session.save(employee1);*/
		 

/*		// Retrieving object using get() method
		Employee employee2 = (Employee) session.get(Employee.class, 1);*/
		
/*		// Deleting rows using session.delete() method	
		employee1.setEmployeeId(1);
		session.delete(employee1);*/
		
/*		//updating rows using update or saveOrUpdate()
		employee.setEmployeeId(2);
		session.update(employee);*/
		
		
		session.getTransaction().commit();
		session.close();

//		System.out.println("Fetching the value from the database--> Firstname: "+employee2.getFirstName()+" lastname: "+employee2.getLastname());

	}

}
