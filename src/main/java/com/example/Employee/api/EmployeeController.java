package com.example.Employee.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/add")
    public @ResponseBody String addEmployee(@RequestBody @Validated Employee employee) {
        employeeService.addEmployee(employee);
        return "Employee added";
    }
}
