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

    public Employee updateNameById(int id, String name) {
        Employee employee = employeeRepository.findById(id).get();
        employee.setName(name);
        employeeRepository.save(employee);
        return employee;
    }

    public Employee updateAgeById(int id, int age) {
        Employee employee = employeeRepository.findById(id).get();
        employee.setAge(age);
        employeeRepository.save(employee);
        return employee;
    }

    public Employee updateAddressById(int id, String address) {
        Employee employee = employeeRepository.findById(id).get();
        employee.setAddress(address);
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
}
