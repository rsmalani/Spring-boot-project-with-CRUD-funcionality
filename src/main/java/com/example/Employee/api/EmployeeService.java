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

    public List<Employee> displayAllEmployee() {
        return (List<Employee>) employeeRepository.findAll();
    }

    public List<Employee> displayByName(String name) {
        return employeeRepository.findByName(name);
    }

    public List<Employee> displayByAge(int age) {
        return employeeRepository.findByAge(age);
    }

    public List<Employee> displayByAddress(String address) {
        return employeeRepository.findByAddress(address);
    }
}
