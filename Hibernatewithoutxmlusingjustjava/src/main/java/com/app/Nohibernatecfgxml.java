package com.app;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.model.Teachers;

public class Nohibernatecfgxml {
	
	public static void main (String [] args)
	{
		Configuration config= new Configuration();
		
		config.setProperty("hibernate.connection.driver_class","com.mysql.cj.jdbc.Driver");
		config.setProperty("hibernate.connection.url","jdbc:mysql://localhost:3306/hibernate");
		config.setProperty("hibernate.connection.username","root");
		config.setProperty("hibernate.connection.password","root");
		config.setProperty("hibernate.dialect","org.hibernate.dialect.MySQLDialect");
		config.setProperty("hibernate.hbm2ddl.auto","update");
		config.setProperty("hibernate.show_sql", "true");
		config.setProperty(" hibernate.format_sql","true");
		
		
		
		SessionFactory sf= config.addAnnotatedClass(Teachers.class).buildSessionFactory();
		Session session = null;
		Transaction transact= null;
		boolean flag=false;
		
		try
		{
			session=sf.openSession();
			transact=session.beginTransaction();
			
			Teachers t1= new Teachers();
			t1.setTcity("mumbai");
			t1.setTid(69);
			t1.setTname("baby");
			
			session.saveOrUpdate(t1);
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
			}
			else
			{
				transact.rollback();
			}
			
			session.close();
			
		}
		
		
		
		
	}

}
