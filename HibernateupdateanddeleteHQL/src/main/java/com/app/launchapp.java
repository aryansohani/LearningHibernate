package com.app;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.model.College;

public class launchapp {
	public static void main (String [] args)
	{
		SessionFactory sf=new Configuration().configure().addAnnotatedClass(College.class).buildSessionFactory();
		Session session =null;
		Transaction transact=null;
		boolean flag=false;
		int count=0;
		
		try
		{
			
			session=sf.openSession();
			transact=session.beginTransaction();
			
			count=session.createMutationQuery("UPDATE College SET cgrade=:grade WHERE cid=1").setParameter("grade", "a").executeUpdate();
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
			if(flag==true)
			{
				transact.commit();
				System.out.println("affected rows"+count);
			}
			else
			{
				transact.rollback();
			}
			session.close();
		}
	}

}
