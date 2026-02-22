package com.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;

import com.model.Answer;
import com.model.Question;

public class launchapp2 {
	public static void main (String [] args)
	{
		Session session=null;
		
		Configuration config= new Configuration();
		
		config.configure().addAnnotatedClass(Question.class).addAnnotatedClass(Answer.class);
		
		SessionFactory sf= config.buildSessionFactory();
		
		session=sf.openSession();
		try
		{
			Question q=session.get(Question.class, 1);
			System.out.println(q);
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
