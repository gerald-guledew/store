package com.gguledew.store.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "profiles")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "bio")
    private String bio;

    @Column(name = "phone_number")
    private String phone_number;

    @Column(name = "date_of_birth")
    private Date date_of_birth;

    @Column(name = "loyalty_points")
    private Long loyalty_points;
}
