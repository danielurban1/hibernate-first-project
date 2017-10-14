package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.Student;

public class CreateStudentName {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();						
		
		
		try{
			Student tempStudent = new Student("aaa", "dudddpa", "kupadsa666@email.com");
			System.out.println("Created new student");
			
			session.beginTransaction();
			
			session.save(tempStudent);
			System.out.println("Saved student");
			
			session.getTransaction().commit();
			System.out.println("Added student do database");
		}
		finally{
			factory.close();
		}
	}

}
