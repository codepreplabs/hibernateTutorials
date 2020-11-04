package com.codepreplabs.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.codepreplabs.entity.Department;

public class SetupTables {

	public static void main(String[] args) {
		
		Department department1 = new Department();
		department1.setDepartmentId(10);
		department1.setDepartmentName("Computer Science");
		
		Department department2 = new Department();
		department2.setDepartmentId(20);;
		department2.setDepartmentName("Mechanical Engineering");
		
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(department1);
		session.save(department2);
		session.getTransaction().commit();
		session.close();

	}

}
