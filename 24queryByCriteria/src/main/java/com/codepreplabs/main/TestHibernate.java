package com.codepreplabs.main;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.codepreplabs.entity.Employee;
import com.codepreplabs.util.HibernateUtil;

public class TestHibernate {

	public static void main(String[] args) {

		criteriaQuery();

	}

	/**
	 * example for a named HQL query.
	 */
	@SuppressWarnings("unchecked")
	public static void criteriaQuery() {

		String firstName = "Jessica";
		SessionFactory sessionFactory = HibernateUtil.getSessionfactory();

		try (Session session = sessionFactory.openSession()) {

			session.beginTransaction();

			CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
			CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
			Root<Employee> root = criteriaQuery.from(Employee.class);
			criteriaQuery.select(root);
			Query<Employee> q = session.createQuery(criteriaQuery);

			List<Employee> employees = q.getResultList();
			for (Employee employee : employees)
				System.out.println(employee.getFirstName());

			session.getTransaction().commit();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
