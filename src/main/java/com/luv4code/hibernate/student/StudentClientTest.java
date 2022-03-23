package com.luv4code.hibernate.student;

import com.luv4code.hibernate.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class StudentClientTest {
    public static void main(String[] args) {
//        createStudent();
        getStudentById();
    }

    private static void getStudentById() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Student student = session.get(Student.class, 1L);
            System.out.println(student);
            Course course = student.getCourse();
            System.out.println(course);
        }
    }

    private static void createStudent() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Long id = (Long) session.save(getStudent());
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    private static Student getStudent() {
        Student student = new Student("Madhav", "madhav.p.akv@gmail.com");
        Course java = new Course("Java", "6 months", 25000.00);
        student.setCourse(java);
        return student;
    }

}
