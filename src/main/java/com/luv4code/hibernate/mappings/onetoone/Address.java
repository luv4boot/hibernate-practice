package com.luv4code.hibernate.mappings.onetoone;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "addresss_id")
    private Long id;

    @Column(name = "street_name")
    private String street;

    @Column(name = "city_name")
    private String city;

    @Column(name = "state_name")
    private String state;

    @OneToOne(mappedBy = "address")
    private Employee employee;

    public Address(String street, String city, String state) {
        this.street = street;
        this.city = city;
        this.state = state;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
