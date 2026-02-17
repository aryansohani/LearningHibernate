package com.app;


import org.hibernate.HibernateException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.model.Teachers;

public class Eagervslazyloading {
	public static void main (String [] args)
	{
		
		SessionFactory sf= new Configuration().configure().addAnnotatedClass(Teachers.class).buildSessionFactory();
		Session session =null;
		boolean flag=false;
		
		
		try
		{
			session=sf.openSession();
//			Teachers t1=session.get(Teachers.class, 1);             //when we use .get() at that time hibernate direct starts jdbc and create object
			
//			Teachers t1=session.load(Teachers.class, 1);          //.load() and .getReference() are same methods but they first create a dummy proxy object and then start jdbc only when different parameters are called
			Teachers t1=session.getReference(Teachers.class, 1);
			System.out.println("The ID is :"+ t1.getTid());
			System.in.read();
			System.out.println("The city is :"+ t1.getTcity());
			System.out.println("The name is :"+ t1.getTname());
			
		  
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{ 
	
			session.close();
			sf.close();
			
		}
	}

}
//see what is lazy loading the methods .load() and .getReference() are both same methods just the thing is that when we retrieve data it first create a
//dummy object of that id and when ask for more parameter hibernate realises that the cheating is caught so it creates jdbc connection and start query and give it
//so because .load() .getReference() first cheat by creating dummy object then start quering when caught so they are called lazy loading
//two objects one dummy one original jdbc
//when no data of id then it gives ObjectNotFoundException

//.get() is direct method it is called early loading or eager loading because once you execute it,it start jdbc quering and environment and provide you everything
//no dummy object creation just 1 objects
//when no data of id it will give null pointer exception


