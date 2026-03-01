package com.app;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.model.phone;

public class lobretrival {

    public static void main(String[] args)
    {

        Configuration config = new Configuration();
        config.configure();

        SessionFactory sf =
        config.addAnnotatedClass(phone.class)
              .buildSessionFactory();

        Session session = sf.openSession();

        FileOutputStream fos = null;
        FileWriter writer = null;

        try
        {

            phone p = session.get(phone.class, 1);

            if(p!=null)
            {

                // SAME extension as original
                fos = new FileOutputStream("output.jpg");

                writer = new FileWriter("output.txt");

                fos.write(p.getImage());

                writer.write(p.getTextfile());

                System.out.println("File retrieved successfully");

            }
            else
            {
                System.out.println("Record not found");
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {

            try {
                if(fos!=null)
                fos.close();
            } catch (IOException e) {}

            try {
                if(writer!=null)
                writer.close();
            } catch (IOException e) {}

            session.close();

        }

    }

}