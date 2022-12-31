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
    public List<Employee> fetchAllEmployees() {
        return employeeService.fetchAllEmployees();
    }

    // This method displays all employees with same name given by end user to the end user.
    @GetMapping("/fetch/all/name")
    public List<Employee> fetchByName(@RequestParam String name) {
        return employeeService.fetchByName(name);
    }

    // This method displays all employees with same age given by end user to the end user.
    @GetMapping("/fetch/all/age")
    public List<Employee> fetchByAge(@RequestParam int age) {
        return employeeService.fetchByAge(age);
    }

    // This method displays all employees with same address given by end user to the end user.
    @GetMapping("/fetch/all/address")
    public List<Employee> fetchByAddress(@RequestParam String address) {
        return employeeService.fetchByAddress(address);
    }

    @PostMapping("/fetch/all/details")
    public Employee fetchEmployeeDetails(@RequestParam String username) {
        return employeeService.fetchEmployeeDetails(username);
    }

    // This method updates employee's name with name given by end user.
    @GetMapping("/update")
    public Employee update(@RequestBody Employee employee) {
        return employeeService.update(employee);
    }

    @PostMapping("/delete/user")
    @ResponseBody
    public String deleteById(@RequestParam int id) {
        return employeeService.deleteById(id);
    }
}
