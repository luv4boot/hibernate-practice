package com.luv4code.hibernate.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "student")
@Data
@NoArgsConstructor
//@DiscriminatorValue(value = "student_type")
public class Student extends Person {

    @Column(name = "school_name", length = 50)
    private String schoolName;

    @Column(name = "fee")
    private float fee;

    @Column(name = "section_name", length = 100)
    private String sectionName;

    public Student(String name, String gender, String schoolName, float fee, String sectionName) {
        super(name, gender);
        this.schoolName = schoolName;
        this.fee = fee;
        this.sectionName = sectionName;
    }
}
