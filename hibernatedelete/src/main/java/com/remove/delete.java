package com.remove;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.model.Student;


public class delete {
	public static void main (String [] args)
	{
		boolean flag = false;
		
		SessionFactory sf= new Configuration()
				.configure()
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = sf.openSession();
		Transaction transact = session.beginTransaction();
		
		try
		{
			Student st= new Student();
			st.setScity("mumbai");
			st.setSid(11);
			st.setSname("lord");
			
			session.remove(st);
			flag=true;
			
			Student st1= new Student();
			st1.setScity("mumbai");
			st1.setSid(14);
			st1.setSname("aryan");
			
			session.merge(st1);
			
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
			if (flag == true)
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
