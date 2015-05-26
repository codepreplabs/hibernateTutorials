package com.codepreplabs.main;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.codeprep.vo.AddressVO;
import com.codepreplabs.entity.Employee;

public class TestHibernate {

	public static void main(String[] args) {

		Employee employee = new Employee();
		employee.setFirstName("Harry");
		employee.setLastname("Potter");
		employee.setDateOfBirth(new Date());

		AddressVO permanentAddressVO = new AddressVO();
		permanentAddressVO.setAddressLine("Privet Drive, Little Whinging,");
		permanentAddressVO.setCity("Surrey");
		permanentAddressVO.setState("England");
		permanentAddressVO.setCountry("United Kingdom");

		AddressVO temporaryAddressVO = new AddressVO();

		temporaryAddressVO
				.setAddressLine("Hogwarts School of Witchcraft and Wizardry");
		temporaryAddressVO.setState("Scotland");
		temporaryAddressVO.setCountry("United Kingdom");
		
		employee.getAddresses().add(temporaryAddressVO);
		employee.getAddresses().add(permanentAddressVO);

		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(employee);
		session.getTransaction().commit();
		session.close();

	}

}
