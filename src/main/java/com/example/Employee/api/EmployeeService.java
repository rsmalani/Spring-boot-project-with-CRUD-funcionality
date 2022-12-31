package com.example.Employee.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public List<Employee> fetchAllEmployees() {
        return (List<Employee>) employeeRepository.findAll();
    }

    public List<Employee> fetchByName(String name) {
        return employeeRepository.findByName(name);
    }

    public List<Employee> fetchByAge(int age) {
        return employeeRepository.findByAge(age);
    }

    public List<Employee> fetchByAddress(String address) {
        return employeeRepository.findByAddress(address);
    }

    public Employee update(Employee employee) {
        employeeRepository.save(employee);
        return employee;
    }

    public String deleteById(int id) {
        boolean ifExists = employeeRepository.existsById(id);
            if (!ifExists) {
                return "The record does not exists";
            }
        employeeRepository.deleteById(id);
        return "Record deleted";
    }

    // To be updated
    public Employee fetchEmployeeDetails(String username) {
        return null;
    }
}
