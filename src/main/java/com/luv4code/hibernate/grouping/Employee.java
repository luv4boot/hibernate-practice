package com.luv4code.hibernate.grouping;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "employee")
@Data
@NoArgsConstructor
@NamedQueries({
        @NamedQuery(
                name = "getTotalSalaryOfEmployeesByDept",
                query = "select dept.name,sum(emp.salary) from Department dept left  outer  join dept.employees emp group by dept having sum(emp.salary)>130000"),
        @NamedQuery(
                name = "Employee.byId",
                query = "FROM Employee WHERE id=:empId"
        )
})
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long id;

    @Column(name = "employee_name")
    private String name;

    @Column(name = "date_of_joining")
    private Date doj;

    private Double salary;

    private BigDecimal bonus;

    @Column(length = 50)
    private String designation;

    @Column(length = 100, unique = true)
    private String email;

    @ManyToOne
    @JoinColumn(name = "dept_id")
    private Department department;

    public Employee(String name, Date doj, Double salary, BigDecimal bonus, String designation, String email) {
        this.name = name;
        this.doj = doj;
        this.salary = salary;
        this.bonus = bonus;
        this.designation = designation;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", doj=" + doj +
                ", salary=" + salary +
                ", bonus=" + bonus +
                ", designation='" + designation + '\'' +
                ", email='" + email + '\'' +
                ", department= " + department +
                '}';
    }
}
