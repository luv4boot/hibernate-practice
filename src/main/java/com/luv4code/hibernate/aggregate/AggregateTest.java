package com.luv4code.hibernate.aggregate;

import com.luv4code.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class AggregateTest {
    public static void main(String[] args) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String HQL = "select new com.luv4code.hibernate.aggregate.EmployeeStatistics(count(emp),avg(emp.salary),min(emp.salary),sum(emp.salary) )from Employee emp";
            Query<EmployeeStatistics> query = session.createQuery(HQL, EmployeeStatistics.class);
            EmployeeStatistics employeeStatistics = query.uniqueResult();
            System.out.println(employeeStatistics.getEmpCount() + "\t" + employeeStatistics.getAvgSal() + "\t" + employeeStatistics.getMinSal() + "\t" + employeeStatistics.getSumOfSal());
        }
    }
}
