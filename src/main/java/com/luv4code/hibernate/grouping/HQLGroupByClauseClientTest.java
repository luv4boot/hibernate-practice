package com.luv4code.hibernate.grouping;

import com.luv4code.hibernate.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class HQLGroupByClauseClientTest {
    public static void main(String[] args) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String HQL = "SELECT dept.name,sum(emp.salary) FROM Department dept left join dept.employees emp group by dept";
            HQLHavingClauseClientTest.query(session, HQL);
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
}
