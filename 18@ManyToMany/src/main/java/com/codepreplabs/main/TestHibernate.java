package com.codepreplabs.main;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.codepreplabs.entity.Employee;
import com.codepreplabs.entity.WorkStation;

public class TestHibernate {

	public static void main(String[] args) {

		Employee employee1 = new Employee();
		employee1.setFirstName("Harry");
		employee1.setLastname("Potter");
		employee1.setDateOfBirth(new Date());
		
		Employee employee2 = new Employee();
		employee2.setFirstName("Bob");
		employee2.setLastname("the builder");
		employee2.setDateOfBirth(new Date());
		
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(employee1);
		employees.add(employee2);
		
		WorkStation station1 = new WorkStation();
		station1.setOperatingSystem("Linux RHEL");
		station1.setHardware("4 GB RAM & 80 GB HDD");
		
		WorkStation station2 = new WorkStation();
		station2.setOperatingSystem("Cent OS");
		station2.setHardware("2 GB RAM & 80 GB HDD");
		
		List<WorkStation> workStations = new ArrayList<WorkStation>();
		workStations.add(station1);
		workStations.add(station2);
		
		// associating the two entities
		
		employee1.setWorkStations(workStations);
		employee2.setWorkStations(workStations);
		
		station1.setEmployees(employees);
		station2.setEmployees(employees);
		

		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(employee1);
		session.save(employee2);
		session.save(station1);
		session.save(station2);
		session.getTransaction().commit();
		session.close();

	}

}
