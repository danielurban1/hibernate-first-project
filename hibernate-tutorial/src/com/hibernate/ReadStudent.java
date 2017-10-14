package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudent {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();						
		
		
		try{
			Student tempStudent1 = new Student("aaaa", "1111", "dafasd@email.com");
			System.out.println("Created new student");
			
			session.beginTransaction();
			
			session.save(tempStudent1);
			System.out.println("Saved student");
			
			session.getTransaction().commit();
			System.out.println("Added student do database");
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			Student aaa = session.get(Student.class, 1);
			System.out.println(aaa);
			session.getTransaction().commit();
		}
		finally{
			factory.close();
		}

	}

}
