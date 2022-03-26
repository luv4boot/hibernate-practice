package com.luv4code.hibernate.mappings.onetomany;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Long id;

    @Column(name = "course_name")
    private String name;
    private double fee;
    private String duration;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    public Course(String name, double fee, String duration) {
        this.name = name;
        this.fee = fee;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", fee=" + fee +
                ", duration='" + duration + '\'' +
                '}';
    }
}
