package com.example.Employee.api.Controller;

import jakarta.persistence.Column;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @Autowired
    private EmployeeController employeeController;
    @GetMapping("employee/display/All")
    public String viewAllEmployees(ModelMap model) {
        model.addAttribute("employeeList", employeeController.fetchAllEmployees());
        return "index";
    }
}
