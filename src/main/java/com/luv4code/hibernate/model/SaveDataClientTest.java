package com.luv4code.hibernate.model;

import com.luv4code.hibernate.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.math.BigDecimal;
import java.text.ParseException;

public class SaveDataClientTest {
    public static void main(String[] args) throws ParseException {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Person person = new Person("Madhav Ponnana", "male");
            Employee employee = new Employee("Kohli", "male", 80000.2872, HibernateUtil.getDoj("23/03/2022"), "IT", new BigDecimal("277.389"), "madhav.p.akv@outlook.com");
            Student student = new Student("Smrithi", "female", "xyz-school", 20000.00f, "12 th standard");

            session.beginTransaction();
            session.save(person);
            session.save(employee);
            session.save(student);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
}
