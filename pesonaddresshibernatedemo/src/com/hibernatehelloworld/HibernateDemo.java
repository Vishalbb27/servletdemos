package com.hibernatehelloworld;

import org.hibernate.Session;

import com.hibernatehelloworld.domain.Address;
import com.hibernatehelloworld.domain.Guide;
import com.hibernatehelloworld.domain.Person;
import com.hibernatehelloworld.domain.Student;
import com.hibernatehelloworld.utils.HibernateUtil;

public class HibernateDemo {
	public static void main(String[] args) {

		 demo2();

	}
	
	private static void demo3() {
		Session session=HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Guide guide = session.get(Guide.class, 1L);
		System.out.println("Number of students for this guide = "+guide.getStudents());
		
		


		session.getTransaction().commit();
		session.close();
	}
	
	private static void demo2() {
		Session session=HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Guide guide = new Guide("ABC201222121698","Robert Clive",2000);
		Student student1=new Student("STU001","Max",guide);
		
		session.save(guide);
		session.persist(student1);

		session.getTransaction().commit();
		session.close();
	}
	
	private static void demo1() {
		Session session=HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Guide guide = new Guide("ABC201222121698","Mike Lawson",2000);
		Student student1=new Student("STU001","Max",guide);
		Student student2=new Student("STU002","John",guide);
		session.save(guide);
		session.save(student1);
		session.save(student2);
		session.getTransaction().commit();
		session.close();
	}
}
