package com.luv4code.hibernate.client;

import com.luv4code.hibernate.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class PersonClient {
    public static void main(String[] args) {

        Person person = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            person = session.get(Person.class, 1L);
            System.out.println(person);
        } catch (HibernateException e) {
            e.printStackTrace();
        }

        person.setName("Madhav P");
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Person person1 = session.get(Person.class, 1L);
            session.merge(person);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }

    }


    private static void createPerson() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Long id = (Long) session.save(getPerson());
            System.out.println("Person registered with id: " + id);
            session.getTransaction().commit();
        }
    }

    private static Person getPerson() {
        Person person = new Person("Madhav", "madhav@gmail.com");
        return person;
    }

}
