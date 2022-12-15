package ru.crudapp.models;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "allusers")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "name")
    @NotEmpty(message = "Name must not be empty")
    @Size(min = 2, max = 30, message = "Name must be between 2 and 30 characters")
    String name;

    @Column(name = "surname")
    @NotEmpty(message = "Surname must not be empty")
    @Size(min = 2, max = 30,message = "Surname must be between 2 and 30 characters")
    String Surname;

    @Column(name = "mail")
    @NotEmpty(message = "Mail must mot be empty")
    @Email(message = "Mail must be valid")
    String mail;

    public User(Long id, String name, String surname, String mail) {
        this.id = id;
        this.name = name;
        Surname = surname;
        this.mail = mail;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", Surname='" + Surname + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }
}
