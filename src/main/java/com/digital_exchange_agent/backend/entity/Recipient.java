package com.digital_exchange_agent.backend.entity;

import jakarta.persistence.*;
import org.hibernate.validator.constraints.Length;

@Entity
public class Recipient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, unique = true)
    private int id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "SURNAME", nullable = false)
    private String surname;

    @Column(name = "SEX", nullable = false)
    private Sex sex;

    @Column(name = "EMAIL", nullable = false)
    private String email;

    @Column(name = "PHONE_NUMBER")
    @Length(max = 25)
    private String phone_number;

    public Recipient(String name, String surname, Sex sex, String email, String phone_number) {
        this.name = name;
        this.surname = surname;
        this.sex = sex;
        this.email = email;
        this.phone_number = phone_number;
    }

    public Recipient(String name) {
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

    public String getEmail() {
        return this.email;
    }

    public String getPhoneNumber() {
        return this.phone_number;
    }

}
