package com.digital_exchange_agent.backend.entity;

import com.digital_exchange_agent.backend.entity.common.enums.Sex;
import jakarta.persistence.*;
import org.hibernate.validator.constraints.Length;

import java.util.List;

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
    @Enumerated(EnumType.STRING)
    private Sex sex;

    @Column(name = "EMAIL", nullable = false)
    private String email;

    @Column(name = "PHONE_NUMBER")
    @Length(max = 25)
    private String phone_number;

    @OneToMany(mappedBy = "recipient")
    private List<Transactions> transaction;

    public Recipient(
            String name,
            String surname,
            Sex sex,
            String email,
            String phone_number) {
        this.name = name;
        this.surname = surname;
        this.sex = sex;
        this.email = email;
        this.phone_number = phone_number;
    }

    public Recipient() {
    }

    @Override
    public String toString() {
        return """
                Recipient {
                    id = %d,
                    name = '%s',
                    surname = '%s',
                    sex = '%s',
                    email = '%s',
                    phone_number = '%s'
                """.formatted(id, name, surname, sex, email, phone_number);
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Sex getSex() {
        return this.sex;
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

    public String getPhoneNumber() {
        return this.phone_number;
    }

    public void setPhoneNumber(String phone_number) {
        this.phone_number = phone_number;
    }

    public List<Transactions> getTransaction() {
        return this.transaction;
    }

    public void setTransaction(List<Transactions> transaction) {
        this.transaction = transaction;
    }
}
