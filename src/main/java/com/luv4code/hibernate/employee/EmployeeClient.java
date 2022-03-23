package com.luv4code.hibernate.employee;

import com.luv4code.hibernate.util.HibernateUtil;
import org.hibernate.Session;

import java.util.Date;

public class EmployeeClient {
    public static void main(String[] args) {
//        createEmployeeAndAddress();
        deleteEmployeeAndAddressById();
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

    private static void deleteEmployeeAndAddressById() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Employee employee = session.get(Employee.class, 1L);
            if (employee != null) {
                session.beginTransaction();
                session.delete(employee);
                session.getTransaction().commit();
            }
        }
    }

}
