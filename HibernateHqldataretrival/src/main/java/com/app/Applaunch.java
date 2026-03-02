package com.app;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.model.College;

public class Applaunch {
	
	public static void main (String [] args)
	{
		Configuration config=new Configuration();
		config.configure();
		SessionFactory sf= config.addAnnotatedClass(College.class).buildSessionFactory();
		Session session=null;

		
		try
		{
			session=sf.openSession();
			
			//FROM College (hql) = SELECT * FROM College(sql)
			
			Query query=session.createQuery("FROM College",College.class);
			List<College>collegelist=query.list();
			
			for(College c:collegelist)
			{
				System.out.println(c);
			}

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
//===============================
//HQL = SQL NOTES
//===============================


//Select all

//HQL = from Phone;
//SQL = select * from phone;



//Select with condition

//HQL = from Phone where price > 20000;
//SQL = select * from phone where price > 20000;



//Select single column

//HQL = select name from Phone;
//SQL = select name from phone;



//Select multiple column

//HQL = select id, name from Phone;
//SQL = select id, name from phone;



//AND condition

//HQL = from Phone where price > 20000 and name='Apple';
//SQL = select * from phone where price > 20000 and name='Apple';



//OR condition

//HQL = from Phone where price > 20000 or name='Samsung';
//SQL = select * from phone where price > 20000 or name='Samsung';



//Order by Asc

//HQL = from Phone order by price asc;
//SQL = select * from phone order by price asc;



//Order by Desc

//HQL = from Phone order by price desc;
//SQL = select * from phone order by price desc;



//Count

//HQL = select count(*) from Phone;
//SQL = select count(*) from phone;



//Update

//HQL = update Phone set price=30000 where id=1;
//SQL = update phone set price=30000 where id=1;



//Delete

//HQL = delete from Phone where id=1;
//SQL = delete from phone where id=1;



//===============================
//MOST IMPORTANT
//===============================

//HQL uses CLASS NAME
//SQL uses TABLE NAME
