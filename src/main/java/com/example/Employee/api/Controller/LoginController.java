package com.example.Employee.api.Controller;

import com.example.Employee.api.Daos.LoginDetails;
import com.example.Employee.api.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;

    protected LoginDetails login(String username, String password) {
        return loginService.login(username, password);
    }

    public LoginDetails fetchLoginDetailsById(int i) {
        return loginService.fetchLoginDetailsById(i);
    }
}
