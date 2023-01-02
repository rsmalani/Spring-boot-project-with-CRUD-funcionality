package com.example.Employee.api.Daos;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "login_details")
public class LoginDetails {

    @Id
    @Column(name = "login_id")
    private int loginId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "login_id")
    private Employee employee;

    @Nonnull
    @Column(name = "login_username")
    private String username;

    @Nonnull
    @Column(name = "login_password")
    private String password;

    public LoginDetails(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getLoginId() {
        return loginId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoginDetails that = (LoginDetails) o;
        return username.equals(that.username) && password.equals(that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }
}
