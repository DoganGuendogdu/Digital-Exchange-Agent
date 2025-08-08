package com.digital_exchange_agent.backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, unique = true)
    private int id;

    @Column(name = "NAME", nullable = false)
    @Length(max = 255)
    private String name;

    @Column(name = "SURNAME", nullable = false)
    @Length(max = 255)
    private String surname;

    @Column(name = "SEX", nullable = false)
    private Sex sex;

    @Column(name = "EMAIL", nullable = false)
    @Email
    @Length(max = 255)
    private String email;

    @Column(name = "PASSWORD", nullable = false)
    @Length(max = 40)
    private String password;

    @Column(name = "PHONE_NUMBER")
    @Length(max = 25)
    private String phoneNumber;

    public Account(String name, String surname, Sex sex, String email, String password, String phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.sex = sex;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public Account() {
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public Sex getSex() {
        return this.sex;
    }


    public String getPhoneNumber() {
        return this.phoneNumber;
    }
}
