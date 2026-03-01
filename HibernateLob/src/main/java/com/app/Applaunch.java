package com.app;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.model.phone;



public class Applaunch {
	public static void main (String [] args)
	{
		Configuration config= new Configuration();
		config.configure();
		SessionFactory sf=config.addAnnotatedClass(phone.class).buildSessionFactory();
		Session session=null;
		Transaction transact=null;
		FileInputStream fis=null;
		FileReader reader=null;
		byte[] image =null;
		char[] textfiles=null;
		boolean flag=false;

		try {
			fis=new FileInputStream("C://Users//USER//Desktop//Lob//Gemini_Generated_Image_x0037x0037x0037x.jpg");
			image=new byte[fis.available()];
			fis.read(image);
			
			File file= new File("C:/Users/USER/Desktop/Lob/aryan.txt");
			reader=new FileReader(file);
			textfiles=new char[(int)file.length()];
			reader.read(textfiles);
			
		} 
		catch (FileNotFoundException e) {
			
			e.printStackTrace();
			
		}
		catch (IOException e) {
			
			e.printStackTrace();
		}
		
		try
		{
			session=sf.openSession();
			transact=session.beginTransaction();
			
			phone p=new phone();
			p.setPid(1);
			p.setPname("aryan");
			p.setImage(image);
			p.setTextfile(textfiles);
			
			session.persist(p);
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
			try {
				fis.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			try {
				reader.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			session.close();
		}
	
	}

}
