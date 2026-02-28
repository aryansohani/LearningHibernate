package com.app;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.model.babies;
import com.model.courses;

public class applaunch {
	public static void main(String [] args)
	{
		Configuration config=new Configuration();
		SessionFactory sf=config.configure().addAnnotatedClass(babies.class).addAnnotatedClass(courses.class).buildSessionFactory();
		Session session=null;
//		Transaction transact=null;
//		boolean flag=false;
		try
		{
			session=sf.openSession();
//			transact=session.beginTransaction();
//			
//			courses c1=new courses();
//			c1.setCid(1);
//			c1.setCname("java");
//			c1.setCprice(100);
//
//			
//			
//			courses c2= new courses();
//			c2.setCid(2);
//			c2.setCname("hibernate");
//			c2.setCprice(200);
//			
//			courses c3=new courses();
//			c3.setCid(3);
//			c3.setCname("c");
//			c3.setCprice(1000);
//			
//			babies b1=new babies();
//			b1.setBid(1);
//			b1.setBname("aryan");
//			
//			Set<courses>coursing=new HashSet<>();
//			coursing.add(c3);
//			coursing.add(c2);
//			b1.setCourselist(coursing);
//			
//
//			babies b2=new babies();
//			b2.setBid(2);
//			b2.setBname("saloni");
//			Set<courses>coursing2=new HashSet<>();
//			coursing2.add(c2);
//			coursing2.add(c1);
//			b2.setCourselist(coursing2);
//			
//			Set<babies>babyforjava=new HashSet<>();
//			babyforjava.add(b2);
//			c1.setBabieslist(babyforjava);
//			
//			Set<babies>babyforhibernate=new HashSet<>();
//			babyforhibernate.add(b2);
//			babyforhibernate.add(b1);
//			c2.setBabieslist(babyforhibernate);
//			
//			Set<babies>babyforc=new HashSet<>();
//			babyforc.add(b1);
//			c3.setBabieslist(babyforc);
//
//			session.saveOrUpdate(c1);
//			session.saveOrUpdate(c2);
//			session.saveOrUpdate(c3);
//			
//			flag=true;
			
			courses c=session.get(courses.class,2);
			System.out.println(c);
			
			babies b=session.get(babies.class, 2);
			System.out.println(b);

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
//			if(flag==true)
//			{
//				transact.commit();
//			}
//			else
//			{
//				transact.rollback();
//			}
			session.close();
		}
	}

}
