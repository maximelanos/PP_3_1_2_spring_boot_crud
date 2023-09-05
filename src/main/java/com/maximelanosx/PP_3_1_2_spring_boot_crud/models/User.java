package com.maximelanosx.PP_3_1_2_spring_boot_crud.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @NotBlank(message = "Ошибка! Вы не ввели имя")
    private String firstName;

    @Column(name = "last_name")
    @NotBlank(message = "Ошибка! Вы не ввели фамилию")
    private String lastName;

    @Column(name = "email")
    @NotBlank(message = "Ошибка! Вы не ввели e-mail")
    @Email(message = "E-mail введен некорректно!")
    private String email;

    public User() {}

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
}
