package com.app;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.model.Employee;


public class launchhibernatetransient {
	public static void main (String [] args)
	{
		boolean flag=false;
		SessionFactory sf= new Configuration().configure().addAnnotatedClass(Employee.class).buildSessionFactory();
		Session session = sf.openSession();
		Transaction transact= session.beginTransaction();
		
		try
		{
			Employee e= new Employee();
			e.setAge(10);
			e.setCity("mumbai");
			e.setEname("aryan");
			e.setId(11);
			
			session.persist(e);
			flag=true;

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
			if (flag==true)
			{
				transact.commit();
			}
			else
			{
				transact.rollback();
			}
			
			session.close();
		}
				           
				             
	}

}
