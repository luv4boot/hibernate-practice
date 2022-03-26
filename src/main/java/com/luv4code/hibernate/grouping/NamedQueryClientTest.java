package com.luv4code.hibernate.grouping;

import com.luv4code.hibernate.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class NamedQueryClientTest {
    public static void main(String[] args) {
//        getTotalSalaryOfEmployeesByDept();
        getEmployeeById();
    }

    private static void getTotalSalaryOfEmployeesByDept() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Object[]> query = session.getNamedQuery("getTotalSalaryOfEmployeesByDept");
            getDepartmentEmployeeDetails(query);
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    static void getEmployeeById() {
        Long empId = 2L;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Employee employee = (Employee) session.getNamedQuery("Employee.byId").setParameter("empId", empId).uniqueResult();
            System.out.println(employee);
        }

    }

    static void getDepartmentEmployeeDetails(Query<Object[]> query) {
        List<Object[]> list = query.list();

        for (Object[] objects : list) {
            String departmentName = (String) objects[0];
            Double totalSalByDept = (Double) objects[1];

            System.out.println("Department Name: " + departmentName);
            System.out.println("Total Salary: " + totalSalByDept);
        }
    }
}
