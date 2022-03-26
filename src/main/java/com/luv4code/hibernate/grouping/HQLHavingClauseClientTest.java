package com.luv4code.hibernate.grouping;

import com.luv4code.hibernate.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class HQLHavingClauseClientTest {
    public static void main(String[] args) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String HQL = "SELECT dept.name,sum(emp.salary) FROM Department dept left join dept.employees emp group by dept having sum(emp.salary)>130000";
            query(session, HQL);
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    static void query(Session session, String HQL) {
        Query<Object[]> query = session.createQuery(HQL, Object[].class);
        NamedQueryClientTest.getDepartmentEmployeeDetails(query);
    }
}
