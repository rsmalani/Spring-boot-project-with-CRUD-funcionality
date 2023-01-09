package com.example.Employee.api.Controller;

import com.example.Employee.api.Daos.Employee;
import com.example.Employee.api.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;


// This is the controller of the app for Employee details.
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // This method responds to HTTP.POST request to the server at "/employee/add" domain to add employee given by the
    // end user.
    @PostMapping("/add")
    public String addEmployee(@RequestBody @Validated Employee employee) {
        employeeService.addEmployee(employee);
        return "Employee added";
    }

    // This method responds to HTTP.GET request to the server at "/employee/fetch/id" domain to get employee with given
    // id by the end user and returns list it.
    @GetMapping("/fetch/id")
    public Employee fetchEmployeeById(@RequestParam int id) {
        return employeeService.fetchById(id);
    }

    // This method responds to HTTP.GET request to the server at "/employee/address/all" domain to get all employees
    // for the end user and returns list of them.
    @GetMapping("/fetch/all")
    public List<Employee> fetchAllEmployees() {
        return employeeService.fetchAllEmployees();
    }

    // This method responds to HTTP.GET request to the server at "/employee/firstName/all" domain to get employees with same
    // first name given by the end user and returns list of them.
    @GetMapping("/fetch/firstName/all")
    public List<Employee> fetchByFirstName(@RequestParam String firstName) throws ResponseStatusException{
        try {
            List<Employee> returnList = employeeService.fetchByFirstName(firstName);
            return returnList;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Enter correct value.", e);
        }
    }
    public List<Employee> returnFetchByFirstName(String firstName) {
        return employeeService.fetchByFirstName(firstName);
    }

    // This method responds to HTTP.GET request to the server at "/employee/lastName/all" domain to get employees with same
    // last name given by the end user and returns list of them.
    @GetMapping("/fetch/lastName/all")
    public List<Employee> fetchByLastName(@RequestParam String LastName) {
        return employeeService.fetchByLastName(LastName);
    }

    // This method responds to HTTP.GET request to the server at "/employee/age/all" domain to get employees with same
    // age given by the end user and returns list of them.
    @GetMapping("/fetch/age/all")
    public List<Employee> fetchByAge(@RequestParam int age) {
        return employeeService.fetchByAge(age);
    }

    // This method responds to HTTP.GET request to the server at "/employee/address/all" domain to get employee's with
    // same address given by the end user and returns list of it.
    @GetMapping("/fetch/address/all")
    public List<Employee> fetchByAddress(@RequestParam String address) {
        return employeeService.fetchByAddress(address);
    }

    // This method responds to HTTP.PUT request to the server at "/employee/update" to
    // update employee's detail given by the end user.
    @PutMapping("/update")
    public Employee update(@RequestBody Employee employee) {
        return employeeService.update(employee);
    }

    // This method responds to HTTP.DELETE request to the server at "/employee/delete" to
    // delete/drop employee's detail.
    @DeleteMapping("/delete/user")
    @ResponseBody
    public String deleteById(@RequestParam int id) {
        return employeeService.deleteById(id);
    }

    @GetMapping("/display/all")
    public String viewAllEmployees(ModelMap model) {
        return "display";
    }

}
