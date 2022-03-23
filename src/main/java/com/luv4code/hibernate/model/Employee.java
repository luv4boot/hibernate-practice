package com.luv4code.hibernate.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "employee")
@Data
@NoArgsConstructor
//@DiscriminatorValue(value = "employee_type")
public class Employee extends Person {
    @Column(name = "salary", columnDefinition = "DECIMAL(7,2)")
    private Double salary;

    @Column(name = "date_of_joining")
    private Date doj;

    @Column(name = "dept_name", length = 30)
    private String deptName;

    @Column(name = "bonus", precision = 6, scale = 3)
    private BigDecimal bonus;

    @Column(name = "email", length = 100, unique = true)
    private String email;

    public Employee(String name, String gender, Double salary, Date doj, String deptName, BigDecimal bonus, String email) {
        super(name, gender);
        this.salary = salary;
        this.doj = doj;
        this.deptName = deptName;
        this.bonus = bonus;
        this.email = email;
    }
}
