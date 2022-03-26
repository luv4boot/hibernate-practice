package com.luv4code.hibernate.mappings.onetoone;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long id;

    @Column(name = "employee_name")
    private String name;

    private String email;
    private double salary;
    private String designation;

    @Column(name = "date_of_joining")
    private Date doj;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    public Employee(String name, String email, double salary, String designation, Date doj) {
        this.name = name;
        this.email = email;
        this.salary = salary;
        this.designation = designation;
        this.doj = doj;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", salary=" + salary +
                ", designation='" + designation + '\'' +
                ", doj=" + doj +
                '}';
    }
}
