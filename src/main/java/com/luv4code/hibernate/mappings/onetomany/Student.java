package com.luv4code.hibernate.mappings.onetomany;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long id;

    @Column(name = "student_name")
    private String name;

    private String email;

    @Column(name = "date_of_birth")
    private Date dob;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
    private List<Course> courseList = new ArrayList<>();

    public Student(String name, String email, Date dob) {
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                '}';
    }
}
