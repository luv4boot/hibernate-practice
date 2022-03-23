package com.luv4code.hibernate.employee;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "employee")
@DynamicUpdate
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long employeeId;

    @Column(name = "employee_name", length = 100, nullable = false)
    private String employeeName;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "date_of_joining")
    private Date doj;

    @Column(name = "salary")
    private Double salary;


    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name = "address_id")
    private Address address;

    public Employee(String employeeName, String email, Date doj, Double salary) {
        this.employeeName = employeeName;
        this.email = email;
        this.doj = doj;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", email='" + email + '\'' +
                ", doj=" + doj +
                ", salary=" + salary +
                '}';
    }
}
