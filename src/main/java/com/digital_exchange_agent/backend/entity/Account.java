package com.digital_exchange_agent.backend.entity;

import com.digital_exchange_agent.backend.entity.common.enums.Sex;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import org.hibernate.validator.constraints.Length;

import java.util.List;

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
    @Enumerated(EnumType.STRING)
    private Sex sex;

    @Column(name = "EMAIL", nullable = false)
    @Email
    @Length(max = 255)
    private String email;

    @Column(name = "PASSWORD", nullable = false)
    @Length(max = 60)
    private String password;

    @Column(name = "PHONE_NUMBER")
    @Length(max = 25)
    private String phoneNumber;

    @OneToMany(mappedBy = "account")
    private List<Transactions> transaction;

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

    public String toString() {
        return """
                  Account {
                        id = %d
                        name = '%s'
                        surname = '%s'
                        sex = %s
                        email = '%s''
                        phoneNumber = '%s'
                }""".formatted(id, name, surname, sex, email, phoneNumber);
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

    public int getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Transactions> getTransaction() {
        return this.transaction;
    }

    public void setTransaction(List<Transactions> transaction) {
        this.transaction = transaction;
    }
}
