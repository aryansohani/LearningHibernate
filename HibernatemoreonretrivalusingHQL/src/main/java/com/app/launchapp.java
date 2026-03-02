package com.app;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.model.College;

public class launchapp {
	public static void main (String [] args)
	{
		SessionFactory sf= new Configuration().configure().addAnnotatedClass(College.class).buildSessionFactory();
		Session session=null;
		
		try
		{
			session=sf.openSession();
			
			Query<College> query= session.createQuery("FROM College WHERE cname=:name",College.class);
			query.setParameter("name", "md");
			List<College>collegelist=query.list();
			collegelist.forEach(c->System.out.println(c));
			
			System.out.println("These is second query");
			
			Query<College> query1= session.createQuery("FROM College WHERE cname IN (:name1,:name2)",College.class);
			query1.setParameter("name1", "md");
			query1.setParameter("name2","vppcoe");
			List<College>collegelist2=query1.list();
			collegelist2.forEach(X->System.out.println(X));
			
			System.out.println("These is third query");
			
			Query<Object[]>query2=session.createQuery("SELECT cid,cname FROM College",Object[].class); //see object[] cause 2 parameter of different type there 
			List<Object[]>collegelist3=query2.list();
			collegelist3.forEach(z->System.out.println(z[0]+" "+z[1])); //the first parameter cid= z[0] and cname=z[1]
	
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
		}
		
		
	}

}
