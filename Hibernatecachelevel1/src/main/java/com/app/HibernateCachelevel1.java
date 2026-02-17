package com.app;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.model.Teachers;

public class HibernateCachelevel1 {
	public static void main (String [] args)
	{
		SessionFactory sf= new Configuration().configure().addAnnotatedClass(Teachers.class).buildSessionFactory();
		Session session1 = null;
		Session session2 =null;
		
		try
		{
			session1=sf.openSession();
			session2=sf.openSession();
			
			Teachers t1= session1.get(Teachers.class,1);
			System.out.println(t1);
			Teachers t2= session1.get(Teachers.class,1);
			System.out.println(t2);
			
			Teachers t3=session2.get(Teachers.class, 1);
			System.out.println(t3);
			Teachers t4=session2.get(Teachers.class, 1);
			System.out.println(t4);
			
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
			session1.close();
			session2.close();
			sf.close();
		}
		
		
		
		
	}

}



//see basically what happening when we make a session by default a cache level 1 memory is allocated to these session
//eg. session1 created it has cached memory now when we retrive data it first check cached memory in case of t1 its not present so it goes to jdbc and create object 
//it also stores these object in cached lvl-1 memory for future
//when we execute t2 of session1 it checks cached first it finds the object and then directly through cached it displays (no jdbc query)

//now in case of session 2 it has its own cached lvl 1 memory so when we execute t3 it check cached of session 2 cause it belongs to cache of session 2 and not session1 
//now after checking it doesnt recieve the data so it executed jdbc query and find the data and create a object and store the data in it and in cached also
//now next time when we create t4 basically we it checks cache of session 2 it finds data there and executes the display


//Hibernate: 
//select
//t1_0.Tid,
//t1_0.Tcity,
//t1_0.Tname 
//from
//Teachers t1_0 
//where
//t1_0.Tid=?
//These is constructor
//Teachers [Tid=1, Tname=aryan, Tcity=mumbai] t1->display jdbc and store in cache of session 1
//Teachers [Tid=1, Tname=aryan, Tcity=mumbai] t2->display (no jdbc you can see)

//Hibernate: 
//select
//t1_0.Tid,
//t1_0.Tcity,
//t1_0.Tname 
//from
//Teachers t1_0 
//where
//t1_0.Tid=?
//These is constructor
//Teachers [Tid=1, Tname=aryan, Tcity=mumbai] t3->jdbc cause session 2 and store in cache
//Teachers [Tid=1, Tname=aryan, Tcity=mumbai] t4-> no jdbc cause already in cache of 2