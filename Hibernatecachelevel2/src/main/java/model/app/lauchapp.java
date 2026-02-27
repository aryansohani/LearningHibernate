package model.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.model.Baby;

public class lauchapp {

    public static void main(String[] args) {

        SessionFactory factory = null;
        Session session = null;
        Transaction tx = null;

        try {

            Configuration config = new Configuration();
            config.configure("hibernate.cfg.xml");
            config.addAnnotatedClass(Baby.class);

            factory = config.buildSessionFactory();

            session = factory.openSession();
            tx = session.beginTransaction();

            Baby b1 = new Baby();
            b1.setId(1);
            b1.setName("aryan");
            b1.setCity("mumbai");

            session.save(b1);

            tx.commit();

            System.out.println("Inserted Successfully ✅");

        } catch (Exception e) {

            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();

        } finally {

            if (session != null) {
                session.close();
            }

            if (factory != null) {
                factory.close();
            }
        }
    }
}