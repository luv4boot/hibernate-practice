package com.luv4code.hibernate.grouping;

import com.luv4code.hibernate.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.math.BigDecimal;
import java.text.ParseException;

public class ClientTest {
    public static void main(String[] args) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            Employee employee1 = new Employee("Madhav", HibernateUtil.getDob("20/06/2018"), 45000.00, new BigDecimal(250.12), "HR Lead", "madhav.p.akv@gmail.com");
            Employee employee2 = new Employee("Yuvraj", HibernateUtil.getDob("16/04/2015"), 75000.00, new BigDecimal(290.12), "Junior HR", "yuvraj@gmail.com");

            Department department1 = new Department("IT Technology", "Hyderabad");

            department1.getEmployees().add(employee1);
            department1.getEmployees().add(employee2);

            employee1.setDepartment(department1);
            employee2.setDepartment(department1);

            session.save(department1);

            Employee employee3 = new Employee("Kohli", HibernateUtil.getDob("20/06/2017"), 50000.00, new BigDecimal(235.12), "IT Manager", "king@gmail.com");
            Employee employee4 = new Employee("Dhoni", HibernateUtil.getDob("16/01/2014"), 60000.00, new BigDecimal(275.12), "Junior IT Manager", "dhoni@gmail.com");
            Employee employee5 = new Employee("Ashwin", HibernateUtil.getDob("10/06/2019"), 30000.00, new BigDecimal(210.12), "Senior IT Manager", "ashwin@gmail.com");

            Department department2 = new Department("IT Management", "Mumbai");

            department2.getEmployees().add(employee3);
            department2.getEmployees().add(employee4);
            department2.getEmployees().add(employee5);

            employee3.setDepartment(department2);
            employee4.setDepartment(department2);
            employee5.setDepartment(department2);

            session.save(department2);

        } catch (HibernateException | ParseException e) {
            e.printStackTrace();
        }
    }
}
