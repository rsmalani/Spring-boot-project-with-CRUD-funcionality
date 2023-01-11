package com.example.Employee.api.Controller;

import com.example.Employee.api.Daos.Employee;
import jakarta.persistence.Column;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WebController {

    @Autowired
    private EmployeeController employeeController;
    @GetMapping("/employee/display/All")
    public String viewAllEmployees(ModelMap model) {
        model.addAttribute("employeeList", employeeController.fetchAllEmployees());
        return "index";
    }

    @GetMapping("/index")
    public String indexPage() {
        return "index";
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

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello";
    }
}
