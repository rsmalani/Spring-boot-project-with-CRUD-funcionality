package com.example.Employee.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    // This is the controller of the app for Employee details.
    @Autowired
    private EmployeeService employeeService;

    // This method adds employee to the database and returns "Employee added" as confirmation message to end user.
    @PostMapping("/add")
    public String addEmployee(@RequestBody @Validated Employee employee) {
        employeeService.addEmployee(employee);
        return "Employee added";
    }

    // This method displays all employee details of the database to the end user.
    @GetMapping("/fetch/all")
    public List<Employee> displayAllEmployee() {
        return employeeService.displayAllEmployee();
    }

    // This method displays all employees with same name given by end user to the end user.
    @GetMapping("/fetch/all/name")
    public List<Employee> displayByName(@RequestParam @Validated String name) {
        return employeeService.displayByName(name);
    }

    // This method displays all employees with same age given by end user to the end user.
    @GetMapping("/fetch/all/age")
    public List<Employee> displayByAge(@RequestParam @Validated int age) {
        return employeeService.displayByAge(age);
    }

    // This method displays all employees with same address given by end user to the end user.
    @GetMapping("/fetch/all/address")
    public List<Employee> displayByAddress(@RequestParam @Validated String address) {
        return employeeService.displayByAddress(address);
    }

    // This method updates employee's name with name given by end user.
    @GetMapping("/update/name")
    public Employee updateNameById(@RequestParam @Validated int id,@RequestParam String name) {
        return employeeService.updateNameById(id, name);
    }

    // This method updates employee's age with age given by end user.
    @GetMapping("/update/age")
    public Employee updateAgeById(@RequestParam @Validated int id,@RequestParam int age) {
        return employeeService.updateAgeById(id, age);
    }

    // This method updates employee's address with address given by end user.
    @GetMapping("/update/address")
    public Employee updateAddressById(@RequestParam @Validated int id,@RequestParam String address) {
        return employeeService.updateAddressById(id, address);
    }

    @PostMapping("/delete/user")
    @ResponseBody
    public String deleteById(@RequestParam @Validated int id) {
        return employeeService.deleteById(id);
    }
}
