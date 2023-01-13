package com.example.Employee.api.Controller;

import com.example.Employee.api.Daos.Employee;
import com.example.Employee.api.Daos.EmployeeRepository;
import com.example.Employee.api.Daos.LoginDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Objects;

@Controller
public class WebController {

    @Autowired
    private EmployeeController employeeController;

    @Autowired
    private LoginController loginController;

    @GetMapping("/employee/display/All")
    public String viewAllEmployees(Model model) {
        model.addAttribute("employeeList", employeeController.fetchAllEmployees());
        return "index";
    }

    @GetMapping("/index")
    public String indexPage() {
        return "index";
    }

    @GetMapping("/employee/add")
    public String addEmployee(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "addEmployee";
    }

    @PostMapping("/employee/add/details")
    public String addEmployeeDetails(@ModelAttribute("employee")Employee employee) {
        employeeController.addEmployee(employee);
        return "redirect:/";
    }
    @GetMapping("/employee/update/{id}")
    public String updateEmployee(@PathVariable("id")int id, Model model) {
        Employee employee = employeeController.fetchEmployeeById(id);
        model.addAttribute("employee", employee);
        return "updateEmployee";
    }

    @GetMapping("/employee/update/details")
    public String updateEmployee(@ModelAttribute("employee")Employee employee) {
        employeeController.update(employee);
        return "redirect:/index";
    }

    @GetMapping("/employee/delete/{id}")
    public String deleteEmployee(@PathVariable("id")int id) {
        employeeController.deleteById(id);
        return "redirect:/index";
    }

    @GetMapping("/login")
    public String login(Model model) {
        LoginDetails loginDetails = new LoginDetails();
        model.addAttribute("loginDetails", loginDetails);
        return "login";
    }

    @PostMapping("/login/details")
    public String login(@ModelAttribute("loginDetails")LoginDetails loginDetails) {
        String username = loginDetails.getUsername();
        String password = loginDetails.getPassword();
        LoginDetails ld = loginController.login(username, password);
        if (ld.equals(null)) {
            return "redirect/login";
        }
        Employee employee = ld.getEmployee();
        if (Objects.equals(employee.getRole(), "Admin")) {
            return "index";
        }
        return "index";
//        return "employeeLogin";
    }
}
