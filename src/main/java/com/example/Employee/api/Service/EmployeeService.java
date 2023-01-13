package com.example.Employee.api.Service;

import com.example.Employee.api.Daos.Employee;
import com.example.Employee.api.Daos.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public  void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public  List<Employee> fetchAllEmployees() {
        return (List<Employee>) employeeRepository.findAll();
    }

    public  List<Employee> fetchByFirstName(String firstName) {
        return employeeRepository.findByFirstName(firstName);
    }

    public  List<Employee> fetchByLastName(String lastName) {
        return employeeRepository.findByLastName(lastName);
    }

    public  List<Employee> fetchByAge(int age) {
        return employeeRepository.findByAge(age);
    }

    public  List<Employee> fetchByAddress(String address) {
        return employeeRepository.findByAddress(address);
    }

    public  Employee update(Employee employee) {
        employeeRepository.save(employee);
        return employee;
    }

    public  String deleteById(int id) {
        if (!employeeRepository.existsById(id)) return "The record does not exists";
        employeeRepository.deleteById(id);
        return "Record deleted";
    }

    public  Employee fetchById(int id) {
        if (!employeeRepository.existsById(id))
            return null;
        return employeeRepository.findById(id);
    }
}
