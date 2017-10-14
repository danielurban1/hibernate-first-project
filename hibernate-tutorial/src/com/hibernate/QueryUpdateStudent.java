package com.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class QueryUpdateStudent {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();						
		
		
		try{
			session.beginTransaction();
			session.createQuery("from Student s where firstName ='aaa'").executeUpdate();
			
			
			session.getTransaction().commit();
		}
		finally{
			factory.close();
		}

	}


}
