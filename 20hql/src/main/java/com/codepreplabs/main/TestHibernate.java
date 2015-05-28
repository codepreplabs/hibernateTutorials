package com.codepreplabs.main;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.codepreplabs.entity.Department;
import com.codepreplabs.entity.Employee;

public class TestHibernate {

	public static void main(String[] args) {
		
		List<Employee> employees = new ArrayList<Employee>();

		Employee employee1 = new Employee();
		employee1.setFirstName("Jhon");
		employee1.setLastname("Doe");
		
		Employee employee2 = new Employee();
		employee2.setFirstName("Jessica");
		employee2.setLastname("Shaw");
		
		employees.add(employee1);
		employees.add(employee2);
		
		Department department1 = new Department();
		department1.setDepartmentName("Computer Science");
		
		Department department2 = new Department();
		department2.setDepartmentName("Public Relations");
		
		employee1.setDepartment(department1);
		employee2.setDepartment(department2);
		
		department1.setEmployees(employees);
		department2.setEmployees(employees);

		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(employee1);
		session.save(employee2);
		session.getTransaction().commit();
		session.close();
		

	}

}
