package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			// start a transaction
			session.beginTransaction();
			
			// query students using HQL (for "Hibernate Query Language")
			// here we query all students from the Student table in our SQL
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			// display the students
			// method was refactored using Eclipse trick so it appears at the bottom of our file now
			displayStudents(theStudents);
			
			// query students: lastName='Harrison'
			// !!! we use the Java property name "lastName" and not the column name "last_name" !!!
			theStudents = session.createQuery("from Student queriedStudent where queriedStudent.lastName='Harrison'").getResultList();
			// display the students
			System.out.println("\n\nStudents who have last name of Harrison:");
			displayStudents(theStudents);
			
			// query students: lastName='Harrison' OR firstName='Daffy'
			theStudents = session.createQuery("from Student queriedStudent where queriedStudent.lastName='Harrison' OR queriedStudent.firstName='Daffy'").getResultList();
			System.out.println("\n\nStudents who have last name of Harrison or first name of Daffy:");
			displayStudents(theStudents);
			
			// query students where email LIKE '%luv2code.com' (ends with 'luv2code.com')
			theStudents = session.createQuery("from Student queriedStudent where queriedStudent.email LIKE '%luv2code.com'").getResultList();
			System.out.println("\n\nStudents who have email ending with 'luv2code.com' : ");
			displayStudents(theStudents);
			
			// query students where email LIKE '%gmail.com' (ends with 'gmail.com')
						theStudents = session.createQuery("from Student queriedStudent where queriedStudent.email LIKE '%gmail.com'").getResultList();
						System.out.println("\n\nStudents who have email ending with 'luv2code.com' : ");
						displayStudents(theStudents);
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done !");

		}
		finally {
			factory.close();
		}

	}

	private static void displayStudents(List<Student> theStudents) {
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

}
