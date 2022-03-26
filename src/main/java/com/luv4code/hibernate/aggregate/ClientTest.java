package com.luv4code.hibernate.aggregate;

import com.luv4code.hibernate.util.HibernateUtil;
import org.hibernate.Session;

public class ClientTest {
    public static void main(String[] args) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Employee madhav = new Employee("Madhav", "madhav@gmail.com", 85000.00);
            Employee kohli = new Employee("Kohli", "kohli@gmail.com", 90000.00);
            Employee rohit = new Employee("Rohit", "rohit@gmail.com", 70000.00);

            session.beginTransaction();
            session.save(madhav);
            session.save(rohit);
            session.save(kohli);
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
