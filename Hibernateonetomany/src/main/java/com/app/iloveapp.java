package com.app;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.model.studentofclass;
import com.model.teacherofclass;

public class iloveapp {
	
	public static void main (String [] args)
	{
		Configuration config= new Configuration();
		SessionFactory sf= config.configure().addAnnotatedClass(studentofclass.class).addAnnotatedClass(teacherofclass.class).buildSessionFactory();
		Session session=null;
//		Transaction transact=null;
//		boolean flag=false;
		
		try
		{
			session=sf.openSession();
//			transact=session.beginTransaction();
//			
//			teacherofclass t1= new teacherofclass();
//			t1.setTid(1);
//			t1.setTname("shani dev");
//			
//			studentofclass s1=new studentofclass();
//			s1.setSid(1);
//			s1.setSname("aryan");
//			s1.setTeacherlist(t1);
//			
//			studentofclass s2=new studentofclass();
//			s2.setSid(2);
//			s2.setSname("sohani");
//			s2.setTeacherlist(t1);
//			
//			List<studentofclass>studentkilist=new ArrayList<studentofclass>();
//			studentkilist.add(s1);
//			studentkilist.add(s2);
//			
//			t1.setStudentlist(studentkilist);
//			
//			session.saveOrUpdate(t1);
//			flag=true;
			
			teacherofclass t1=session.get(teacherofclass.class, 1);
			System.out.println(t1);
			
			studentofclass s1=session.get(studentofclass.class,2);
			System.out.println(s1);
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
//				transact.rollback();;
//			}
			session.close();
		}
	}

}
