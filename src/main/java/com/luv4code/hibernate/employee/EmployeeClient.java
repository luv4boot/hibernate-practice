package com.luv4code.hibernate.employee;

import com.luv4code.hibernate.util.HibernateUtil;
import org.hibernate.Session;

import java.util.Date;

public class EmployeeClient {
    public static void main(String[] args) {
//        createEmployeeAndAddress();
//        getEmployeeAndAddressByEmployeeId();
        getEmployeeAndAddressByAddressId();
    }

    private static void getEmployeeAndAddressByAddressId() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Address address = session.get(Address.class, 3L);
            System.out.println(address);
            if (address != null) {
                address.getEmployeeList().forEach(System.out::println);
            }
        }
    }

    private static void getEmployeeAndAddressByEmployeeId() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Employee employee = session.get(Employee.class, 1L);
            System.out.println(employee);
            if (employee != null) {
                employee.getAddressList().forEach(System.out::println);
            }
        }
    }

    private static void createEmployeeAndAddress() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Employee employee1 = new Employee("Madhav", "madhav@gmail.com", new Date(), 50000.00);
            Employee employee2 = new Employee("Kohli", "kohli@gmail.com", new Date(), 80000.00);

            Address address1 = new Address("X-Street", "HYD", 500001L, "TS");
            Address address2 = new Address("Y-Street", "CHN", 500300L, "TN");
            Address address3 = new Address("Z-Street", "VSKP", 550001L, "AP");

            employee1.getAddressList().add(address1);
            employee1.getAddressList().add(address2);
            employee1.getAddressList().add(address3);

            address1.getEmployeeList().add(employee1);
            address2.getEmployeeList().add(employee1);
            address3.getEmployeeList().add(employee1);

            employee2.getAddressList().add(address2);
            employee2.getAddressList().add(address3);

            address2.getEmployeeList().add(employee2);
            address3.getEmployeeList().add(employee2);

            session.persist(employee1);
            session.persist(employee2);

            session.getTransaction().commit();


        }
    }

}
