package com.gguledew.store.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="street", nullable = false)
    private String street;

    @Column(name="city", nullable = false)
    private String city;

    @Column(name="zip", nullable = false)
    private String zip;

    @Column(name="state", nullable = false)
    private String state;

    @Column(name="user_id", nullable = false)
    private Long user_id;
}
