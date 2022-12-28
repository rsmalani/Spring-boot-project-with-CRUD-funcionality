package com.example.Employee.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/add")
    public String addEmployee(@RequestBody @Validated Employee employee) {
        employeeService.addEmployee(employee);
        return "Employee added";
    }

    @GetMapping("/fetch/all")
    public List<Employee> displayAllEmployee() {
        return employeeService.displayAllEmployee();
    }

    @GetMapping("/fetch/all/name")
    public List<Employee> displayByName(@RequestParam @Validated String name) {
        return employeeService.displayByName(name);
    }

    @GetMapping("/fetch/all/age")
    public List<Employee> displayByAge(@RequestParam @Validated int age) {
        return employeeService.displayByAge(age);
    }

    @GetMapping("/fetch/all/address")
    public List<Employee> displayByAddress(@RequestParam @Validated String address) {
        return employeeService.displayByAddress(address);
    }
}
