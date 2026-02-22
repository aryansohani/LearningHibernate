package com.app;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.model.Teachers;

public class launchapp {
	public static void main(String [] args)
	{
		Configuration config= new Configuration();
		
		SessionFactory sf=config.addAnnotatedClass(Teachers.class).buildSessionFactory();
		Session session = null;
		boolean flag=false;
		Transaction transact=null;
		
		try
		{
			session=sf.openSession();
			transact=session.beginTransaction();
			Teachers t1= new Teachers();
			t1.setTcity("mumbai");
			t1.setTid(17);
			t1.setTname("budhya");
			
			session.persist(t1);
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
