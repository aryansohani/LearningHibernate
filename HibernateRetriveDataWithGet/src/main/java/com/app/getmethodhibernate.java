package com.app;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.model.Employee;

public class getmethodhibernate {
	public static void main (String [] args)
	{
		SessionFactory sf= new Configuration().configure().addAnnotatedClass(Employee.class).buildSessionFactory();
		
		Session session=null;
		
		try
		{
			session=sf.openSession();
			
			
			Employee e = session.get(Employee.class,11);
			System.out.println(e);
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
