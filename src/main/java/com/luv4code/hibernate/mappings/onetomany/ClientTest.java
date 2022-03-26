package com.luv4code.hibernate.mappings.onetomany;

import com.luv4code.hibernate.util.HibernateUtil;
import org.hibernate.Session;

public class ClientTest {
    public static void main(String[] args) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            Student student = new Student("Madhav", "madhav.p.akv@gmial.com", HibernateUtil.getDob("20/06/1994"));
            Course course1 = new Course("Hibernate", 10000.00, "90 days");
            Course course2 = new Course("Spring", 20000.00, "150 days");

            student.getCourseList().add(course1);
            student.getCourseList().add(course2);

            course1.setStudent(student);
            course2.setStudent(student);

            session.beginTransaction();
            session.persist(student);
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
