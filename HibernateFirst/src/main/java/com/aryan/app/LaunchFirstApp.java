package com.aryan.app;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.aryan.model.Student;

public class LaunchFirstApp {

	public static void main (String [] args)
	{
		
		//step1.get configuration object
		
		Configuration config= new Configuration();
		
		//step2.configure hibernate.cgf.xml file to configuration
		config.configure();                                           //		config.configure("");
		
		
		//step3.create sessionfactory object
		SessionFactory sessionFactory = config.buildSessionFactory();
		
		//step4.get session object
		Session session=sessionFactory.openSession(); 
		
		//step 5
		Transaction transaction=session.beginTransaction();
		
		Student student=new Student();
		student.setSid(1);
		student.setSname("aryan");
		student.setScity("mumbai");
		
		
		//step 6 perform transaction
		session.save(student);
		
		//7 commit/rollback
		transaction.commit();
		
		//close resources
		session.close();
		
		
	}
}
