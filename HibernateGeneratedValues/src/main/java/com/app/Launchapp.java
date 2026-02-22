package com.app;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.model.Engineers;

public class Launchapp {
	
	public static void main(String[] args)
	{
		SessionFactory sf=new Configuration().configure().addAnnotatedClass(Engineers.class).buildSessionFactory();
		
		Session session =null;
		
		boolean flag=false;
		
		Transaction transact=null;
		
		try
		{
			session=sf.openSession();
			transact=session.beginTransaction();
			
			Engineers e5= new Engineers();
			
			e5.setCity("mumbai");
			e5.setName("saloni");
			session.persist(e5);
			
			Engineers e3=new Engineers();
			e3.setCity("banglore");
			e3.setName("babay");
			session.persist(e3);
			
			Engineers e4=new Engineers();
			e4.setCity("delhi");
			e4.setName("done");
			session.persist(e4);

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
		finally {
			if(flag==true)
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
