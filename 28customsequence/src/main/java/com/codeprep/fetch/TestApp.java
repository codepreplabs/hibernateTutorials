package com.codeprep.fetch;

import com.codeprep.entity.Employee;
import com.codeprep.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class TestApp {
    public static void main(String[] args) {
        Session session1 = HibernateUtil.getSessionFactory().openSession();
        session1.beginTransaction();
        // Add new Employee object
        Employee emp = new Employee();
        emp.setEmail("demo-user@mail.com");
        emp.setName("demo");
        session1.save(emp);
        session1.getTransaction().commit();

        Session session2 = HibernateUtil.getSessionFactory().openSession();
        session2.beginTransaction();

        Query query = session2.createQuery("from Employee ");
        List<Employee> employees = query.list();
        for (Employee employee : employees) {
            System.out.println(emp.toString());
        }
        session2.getTransaction().commit();

        HibernateUtil.shutdown();
        System.out.println("success");
    }
}