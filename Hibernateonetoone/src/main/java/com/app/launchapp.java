package com.app;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.model.Answer;
import com.model.Question;

public class launchapp {
	public static void main( String[] args)
	{
		Session session=null;
		Transaction transact=null;
		boolean flag=false;
		
		Configuration config= new Configuration();
		
		config.configure().addAnnotatedClass(Question.class).addAnnotatedClass(Answer.class);
		
		SessionFactory sf= config.buildSessionFactory();
		
		Question q1= new Question();
		q1.setId(1);
		q1.setQuestion("what are you");
		
		Answer a1= new Answer();
		a1.setId(1);
		a1.setAnswer("i am the best");
		
		q1.setAnswer(a1);
		
		Question q2 = new Question();
		q2.setId(2);
		q2.setQuestion("Where are you from?");

		Answer a2 = new Answer();
		a2.setId(2);
		a2.setAnswer("I am from Mumbai");

		
		q2.setAnswer(a2);
		
		try
		{
			session=sf.openSession();
			transact=session.beginTransaction();
			
			session.persist(q1);
			session.persist(q2);
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
