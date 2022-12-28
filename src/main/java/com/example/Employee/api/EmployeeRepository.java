package com.example.Employee.api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findByName(String name);

    List<Employee> findByAge(int age);

    List<Employee> findByAddress(String address);
}
