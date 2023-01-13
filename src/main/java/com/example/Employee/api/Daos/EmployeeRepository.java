package com.example.Employee.api.Daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findByFirstName(String firstName);

    List<Employee> findByLastName(String firstName);

    List<Employee> findByAge(int age);

    List<Employee> findByAddress(String address);

    Employee findById(int id);
}
