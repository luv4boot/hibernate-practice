package com.luv4code.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HibernateUtil {
    private static SessionFactory sessionFactory;
    private static StandardServiceRegistry serviceRegistry;

    static {
        if (sessionFactory == null) {
            serviceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
            Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();
            sessionFactory = metadata.getSessionFactoryBuilder().build();
        } else if (serviceRegistry != null) {
            StandardServiceRegistryBuilder.destroy(serviceRegistry);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static Date getDob(String doj) throws ParseException {
        Date date = null;

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            date = dateFormat.parse(doj);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

}
