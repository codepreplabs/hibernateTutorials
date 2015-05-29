package com.codepreplabs.main;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.codepreplabs.entity.Department;
import com.codepreplabs.entity.Employee;

public class SetupTables {

	public static void main(String[] args) {
		
		List<Employee> employees = new ArrayList<Employee>();

		Employee employee1 = new Employee();
		employee1.setFirstName("Jhon");
		employee1.setLastname("Doe");
		
		Employee employee2 = new Employee();
		employee2.setFirstName("Jessica");
		employee2.setLastname("Shaw");
		
		Employee employee3 = new Employee();
		employee3.setFirstName("Jhon");
		employee3.setLastname("Deere");
		
		Employee employee4 = new Employee();
		employee4.setFirstName("Dheeraj");
		employee4.setLastname("Shaw");
		
		Employee employee5 = new Employee();
		employee5.setFirstName("Jessica");
		employee5.setLastname("Simpson");
		
		Employee employee6 = new Employee();
		employee6.setFirstName("Jasmine");
		employee6.setLastname("Lal");
		
		Employee employee7 = new Employee();
		employee7.setFirstName("Aicole");
		employee7.setLastname("Anistone");
		
		Employee employee8 = new Employee();
		employee8.setFirstName("Jessica");
		employee8.setLastname("Balmer");
		
		Employee employee9 = new Employee();
		employee9.setFirstName("Jhon");
		employee9.setLastname("Snow");
		
		Employee employee10 = new Employee();
		employee10.setFirstName("Jim");
		employee10.setLastname("Henry");
		
		employees.add(employee1);
		employees.add(employee2);
		employees.add(employee3);
		employees.add(employee4);
		employees.add(employee5);
		employees.add(employee6);
		employees.add(employee7);
		employees.add(employee8);
		employees.add(employee9);
		employees.add(employee10);
		
		Department department1 = new Department();
		department1.setDepartmentName("Computer Science");
		
		Department department2 = new Department();
		department2.setDepartmentName("Public Relations");
		
		employee1.setDepartment(department1);
		employee2.setDepartment(department2);
		employee3.setDepartment(department1);
		employee4.setDepartment(department2);
		employee5.setDepartment(department1);
		employee6.setDepartment(department2);
		employee7.setDepartment(department1);
		employee8.setDepartment(department2);
		employee9.setDepartment(department1);
		employee10.setDepartment(department2);
		
		department1.setEmployees(employees);
		department2.setEmployees(employees);

		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(employee1);
		session.save(employee2);
		session.save(employee3);
		session.save(employee4);
		session.save(employee5);
		session.save(employee6);
		session.save(employee7);
		session.save(employee8);
		session.save(employee9);
		session.save(employee10);
		session.getTransaction().commit();
		session.close();
		

	}

}
