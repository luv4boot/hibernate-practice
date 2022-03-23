package com.luv4code.hibernate.employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long id;

    @Column(name = "street_name")
    private String street;

    @Column(name = "city_name")
    private String city;

    @Column(name = "pin_code")
    private Long pincode;

    @Column(name = "state_name")
    private String state;


    public Address(String street, String city, Long pincode, String state) {
        this.street = street;
        this.city = city;
        this.pincode = pincode;
        this.state = state;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", pincode=" + pincode +
                ", state='" + state + '\'' +
                '}';
    }
}
