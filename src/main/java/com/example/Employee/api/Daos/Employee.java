package com.example.Employee.api.Daos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "emp_id")
    private int id;
    @Nonnull
    @Column(name = "emp_firstname")
    private String firstName;

    @Nonnull
    @Column(name = "emp_lastname")
    private String lastName;
    @Column(name = "emp_age")
    private int age;
    @Column(name = "emp_address")
    private String address;

    @Column(name="emp_username")
    private String username;

    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private LoginDetails loginDetails;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Employee(String firstName, String lastName, int age, String address) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.address = address;
    }

    public Employee() {
        super();
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", username='" + username + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && age == employee.age && firstName.equals(employee.firstName) && lastName.equals(employee.lastName) && address.equals(employee.address) && username.equals(employee.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, age, address, username);
    }
}
