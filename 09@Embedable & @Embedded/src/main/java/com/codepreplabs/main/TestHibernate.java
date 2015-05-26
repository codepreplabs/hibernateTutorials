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
		employee.setFirstName("CodePrep");
		employee.setLastname("labs");
		employee.setDateOfBirth(new Date());
		
		AddressVO addressVO = new AddressVO();
		addressVO.setAddressLine("Hello street, 7th cross");
		addressVO.setCity("gotham");
		addressVO.setState("fiction");
		addressVO.setCountry("illusionary");
		
		employee.setAddressVO(addressVO);
		
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(employee);
		session.getTransaction().commit();
		session.close();

	}

}
