package com.luv4code.hibernate.mappings.onetoone;

import com.luv4code.hibernate.util.HibernateUtil;
import org.hibernate.Session;

import java.util.Date;

public class ClientTest {
    public static void main(String[] args) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Employee employee = new Employee("Madhav", "madhav.p.akv@gmail.com", 25000.00, "IT", new Date());
            Address address = new Address("X-Street", "Hyderabad", "TS");
            employee.setAddress(address);

            session.beginTransaction();
            session.save(employee);
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
