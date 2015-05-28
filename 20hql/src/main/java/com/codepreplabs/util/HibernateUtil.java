package com.codepreplabs.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private HibernateUtil(){
		
	}
	
	private static SessionFactory sessionFactory;
	
	static{
		try{
			sessionFactory = new Configuration().configure().buildSessionFactory();
		}catch(Throwable e){
			System.out.println(e.getMessage());
		}
		
	}

	public static SessionFactory getSessionfactory() {
		return sessionFactory;
	}
	
	
	
	

}
