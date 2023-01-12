package com.example.Employee.api.Controller;

import com.example.Employee.api.Daos.Employee;
import com.example.Employee.api.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@Controller
class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    protected void addEmployee(Employee employee) {
        employeeService.addEmployee(employee);
    }

    protected Employee fetchEmployeeById(@RequestParam int id) {
        return employeeService.fetchById(id);
    }

    protected List<Employee> fetchAllEmployees() {
        return employeeService.fetchAllEmployees();
    }

    protected List<Employee> fetchByFirstName(@RequestParam String firstName) throws ResponseStatusException{
        try {
            return employeeService.fetchByFirstName(firstName);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Enter correct value.", e);
        }
    }
    protected List<Employee> returnFetchByFirstName(String firstName) {
        return employeeService.fetchByFirstName(firstName);
    }

    @GetMapping("/fetch/lastName/all")
    protected List<Employee> fetchByLastName(@RequestParam String LastName) {
        return employeeService.fetchByLastName(LastName);
    }

    protected List<Employee> fetchByAge(@RequestParam int age) {
        return employeeService.fetchByAge(age);
    }

    protected List<Employee> fetchByAddress(@RequestParam String address) {
        return employeeService.fetchByAddress(address);
    }

    protected String update(Employee employee) {
        employeeService.update(employee);
        return "Employee updated";
    }

    @ResponseBody
    protected String deleteById(@RequestParam int id) {
        return employeeService.deleteById(id);
    }

}
