package com.luv4code.hibernate.employee;

import com.luv4code.hibernate.util.HibernateUtil;
import org.hibernate.Session;

import java.util.Date;

public class EmployeeClient {
    public static void main(String[] args) {
        createEmployeeAndAddress();
//        getEmployeeAndAddressByEmployeeId();
//        getEmployeeAndAddressByAddressId();
    }

    private static void getEmployeeAndAddressByAddressId() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Address address = session.get(Address.class, 1L);
            System.out.println(address);
        }
    }

    private static void getEmployeeAndAddressByEmployeeId() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Employee employee = session.get(Employee.class, 1L);
            System.out.println(employee);
        }
    }

    private static void createEmployeeAndAddress() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Long id = (Long) session.save(getEmployee());
            System.out.println("Employee created with id: " + id);
            session.getTransaction().commit();
        }
    }

    private static Employee getEmployee() {
        Employee employee = new Employee("Madhav", "madhav@gmail.com", new Date(), 50000.00);
        Address homeAddress = new Address("Main-Street", "SKLM", 532427L, "AP");
        Address officeAddress = new Address("XYX", "HYD", 500038L, "TS");
        employee.getAddressList().add(homeAddress);
        employee.getAddressList().add(officeAddress);
        return employee;
    }
}
