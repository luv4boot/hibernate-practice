package com.luv4code.hibernate.employee;

import com.luv4code.hibernate.util.HibernateUtil;
import org.hibernate.Session;

import java.util.Date;

public class EmployeeClient {
    public static void main(String[] args) {
        createEmployeeAndAddress();
    }


    private static void createEmployeeAndAddress() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Employee employee1 = new Employee("Madhav", "madhav@gmail.com", new Date(), 50000.00);
            Address address1 = new Address("X-Street", "HYD", 500001L, "TS");
            employee1.setAddress(address1);

            session.persist(employee1);

            session.getTransaction().commit();


        }
    }

}
