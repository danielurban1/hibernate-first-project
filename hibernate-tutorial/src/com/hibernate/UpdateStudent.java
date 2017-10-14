package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudent {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();						
		
		
		try{

			
			session.beginTransaction();
			
			Student aaa = session.get(Student.class, 1);
			aaa.setFirstName("Marian");
			System.out.println(aaa);
			session.getTransaction().commit();
		}
		finally{
			factory.close();
		}

	}

}
