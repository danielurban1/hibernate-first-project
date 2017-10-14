package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();						
		
		
		try{
			Student tempStudent1 = new Student("xxx", "xxx", "dafasd@email.com");
			Student tempStudent2 = new Student("yyy", "yyy", "dafasd@email.com");
			System.out.println("Created new student");
			
			session.beginTransaction();
			
			session.save(tempStudent1);
			session.save(tempStudent2);
			System.out.println("Saved student");
			
			session.getTransaction().commit();
			System.out.println("Added student do database");
		}
		finally{
			factory.close();
		}

	}

}
