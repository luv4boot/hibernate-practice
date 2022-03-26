package com.luv4code.hibernate.mappings.onetoone;

import com.luv4code.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.Date;
import java.util.List;

public class HibernateClientTest {
    public static void main(String[] args) {
        getEmployeeAddressDetailsByEmployeeId();
//        getEmployeeAddressDetailsByAddressId();
    }

    private static void getEmployeeAddressDetailsByAddressId() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String HQL = "FROM Address addr left outer join fetch addr.employee where addr.id=:addrId";
            Address address = session.createQuery(HQL, Address.class).setParameter("addrId", 1L).uniqueResult();
            System.out.println(address);
            Employee employee = address.getEmployee();
            System.out.println(employee);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static void getEmployeeAddressDetailsByEmployeeId() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String HQL = "select emp.name,emp.doj, emp.salary, addr.city, addr.state " +
                    "FROM Employee emp left join  emp.address addr where emp.id=:empId";
            Query query = session.createQuery(HQL);
            query.setParameter("empId", 1L);
            List<Object[]> list = query.list();

            for (Object[] objects : list) {
                String employeeName = (String) objects[0];
                Date doj = (Date) objects[1];
                Double salary = (Double) objects[2];
                String city = (String) objects[3];
                String state = (String) objects[4];
                System.out.println(employeeName + "\t" + doj + "\t" + salary + "\t" + city + "\t" + state);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   /* private static void getEmployeeAddressDetailsByEmployeeId() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String HQL = "FROM Employee emp left join fetch emp.address where emp.id=:empId";
            Query<Employee> query = session.createQuery(HQL, Employee.class);
            query.setParameter("empId", 1L);
            Employee employee = query.uniqueResult();
            System.out.println(employee);
            Address address = employee.getAddress();
            System.out.println(address);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
}
