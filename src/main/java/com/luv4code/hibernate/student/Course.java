package com.luv4code.hibernate.student;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@DynamicUpdate
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Long id;

    @Column(name = "course_name")
    private String name;

    @Column(name = "course_duration")
    private String duration;

    @Column(name = "course_fee")
    private double fee;

    @OneToOne(mappedBy = "course")
    private Student student;

    public Course(String name, String duration, double fee) {
        this.name = name;
        this.duration = duration;
        this.fee = fee;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", duration='" + duration + '\'' +
                ", fee=" + fee +
                '}';
    }
}
