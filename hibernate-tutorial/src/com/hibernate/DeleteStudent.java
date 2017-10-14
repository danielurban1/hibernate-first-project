package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudent {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();						
		
		
		try{

			
			session.beginTransaction();
			
			session.createQuery("delete from Student where firstName = 'xxx'").executeUpdate();
			session.getTransaction().commit();
		}
		finally{
			factory.close();
		}

	}

}
