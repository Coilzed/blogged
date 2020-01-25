package com.blogged.pet.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

import java.io.Serializable;

import java.time.LocalDate;

@Entity
@Table(name = "`user`")
public class User implements Serializable {

    private static final long serialVersionUID = 3157142951964534069L;

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    @Column(name = "email", length = 65, nullable = false, unique = true)
    private String email;

    @Column(name = "first_name", length = 50)
    private String firstName;

    @Column(name = "last_name", length = 50)
    private String lastName;

    @Column(name = "password", length = 65)
    private String password;

    @Column(name = "register_date")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate registerDate;

    @Column(name = "last_login")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate lastLogin;

    @Enumerated(EnumType.STRING)
    private Role role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDate registerDate) {
        this.registerDate = registerDate;
    }

    public LocalDate getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(LocalDate lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", registerDate=" + registerDate +
                ", lastLogin=" + lastLogin +
                ", role=" + role +
                '}';
    }
}
