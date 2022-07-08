package ru.pcs.web.models;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    @NotEmpty(message = "Поле ИМЯ - не должно быть пустым")
    @Size(min = 2, message = "Имя из одной буквы? - НЕ ВЕРЮ!")
    private String firstName;

    @Column(name = "last_name")
    @NotEmpty(message = "Поле ФАМИЛИЯ - не должно быть пустым")
    @Size(min = 2, message = "Фамилия из одной буквы? - НЕ ВЕРЮ!")
    private String lastName;

    @Column(name = "email")
    @NotEmpty(message = "Введите почту")
    @Email(message = "Это точно электропочта?")
    private String email;

    public User() {
    }

    public User(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User {" +
               "id = " + id +
               ", firstName = '" + firstName + '\'' +
               ", lastName = '" + lastName + '\'' +
               ", email = '" + email + '\'' +
               '}';
    }
}
