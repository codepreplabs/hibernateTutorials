package com.codepreplabs.main;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.codepreplabs.entity.Address;
import com.codepreplabs.entity.Employee;

public class TestHibernate {

	public static void main(String[] args) {

		Employee employee = new Employee();
		employee.setFirstName("Harry");
		employee.setLastname("Potter");
		employee.setDateOfBirth(new Date());

		Address permanentAddressVO = new Address();
		permanentAddressVO.setAddressLine("Privet Drive, Little Whinging,");
		permanentAddressVO.setCity("Surrey");
		permanentAddressVO.setState("England");
		permanentAddressVO.setCountry("United Kingdom");
		permanentAddressVO.setEmployee(employee);

		Address temporaryAddressVO = new Address();

		temporaryAddressVO
				.setAddressLine("Hogwarts School of Witchcraft and Wizardry");
		temporaryAddressVO.setState("Scotland");
		temporaryAddressVO.setCountry("United Kingdom");
		temporaryAddressVO.setEmployee(employee);

		List<Address> addresses = new ArrayList<Address>();
		addresses.add(temporaryAddressVO);
		addresses.add(permanentAddressVO);

		employee.setAddresses(addresses);

		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(employee);
		session.save(temporaryAddressVO);
		session.save(permanentAddressVO);
		session.getTransaction().commit();
		session.close();

	}

}
