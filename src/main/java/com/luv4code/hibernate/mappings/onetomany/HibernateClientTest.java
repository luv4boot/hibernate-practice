package com.luv4code.hibernate.mappings.onetomany;

import com.luv4code.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class HibernateClientTest {
    public static void main(String[] args) {
//        getStudentCourseByStudentId1();
        getStudentCourseByStudentId2();
    }

    private static void getStudentCourseByStudentId2() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String HQL = "SELECT student.name,student.email,course.name,course.fee FROM Student student left join student.courseList course where student.id=:studentId";
            Query<Object[]> query = session.createQuery(HQL);
            query.setParameter("studentId", 1L);
            List<Object[]> list = query.list();

            for (Object[] objects : list) {
                String studentName = (String) objects[0];
                String studentEmail = (String) objects[1];
                String courseName = (String) objects[2];
                Double courseFee = (Double) objects[3];

                System.out.println(studentName + "\t" + studentEmail + "\t" + courseName + "\t" + courseFee);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static void getStudentCourseByStudentId1() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String HQL = "FROM Student WHERE id=:studentId";
            Student student = session.createQuery(HQL, Student.class).setParameter("studentId", 1L).uniqueResult();
            System.out.println(student);

            if (student != null) {
                student.getCourseList().forEach(System.out::println);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
