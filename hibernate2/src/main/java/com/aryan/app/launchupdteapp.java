package com.aryan.app;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.aryan.model.Student;

public class launchupdteapp {
	
	public static void main(String [] args)
	{
		Configuration config=null;
		SessionFactory sessionfactory=null;
		Session session=null;
		boolean flag=false;
		Transaction trans=null;
		
		config=new Configuration();
		config.configure();
		sessionfactory=config.buildSessionFactory();
		
		session=sessionfactory.openSession();
		
		Student s1= new Student();
		s1.setSname("lord");
		s1.setScity("mumbai");
		s1.setSid(11);
	
		Student s2= new Student();
		s2.setSid(21);
		s2.setSname("baby");
		s2.setScity("na");
		
		
		try
		{
			
			trans=session.beginTransaction();
			session.update(s1);
			session.saveOrUpdate(s2);
			
			
			flag=true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (flag==true)
			{
				trans.commit();
			}
			else
			{
				trans.rollback();
			}
		}
		
				
		
		
	}

}
