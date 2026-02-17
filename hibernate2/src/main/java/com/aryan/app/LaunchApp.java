package com.aryan.app;

import org.hibernate.Session;


import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.aryan.model.Student;

public class LaunchApp {

    public static void main(String[] args) {

        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction transaction = null;

        try {
            // Load configuration
            Configuration configuration = new Configuration();
            configuration.configure();  // loads hibernate.cfg.xml

            sessionFactory = configuration.buildSessionFactory();
            session = sessionFactory.openSession();

            // Begin Transaction
            transaction = session.beginTransaction();

            // Create Student Objects
            Student s1 = new Student();
            s1.setSid(11);
            s1.setSname("aryan");
            s1.setScity("Mumbai");
            
            Student s2 = new Student();
            s2.setSid(26);
            s2.setSname("mrunal");
            s2.setScity("Mumbai");

          

            // Persist Objects
           
            session.persist(s1);
            session.persist(s2);

            // Commit
            transaction.commit();

            System.out.println("Records inserted successfully!");

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();

        } finally {

            if (session != null)
                session.close();

            if (sessionFactory != null)
                sessionFactory.close();
        }
    }
}
