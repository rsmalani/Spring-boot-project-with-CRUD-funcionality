package com.example.Employee.api.Service;

import com.example.Employee.api.Daos.LoginDetails;
import com.example.Employee.api.Daos.LoginDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    private LoginDetailsRepository loginDetailsRepository;
    public LoginDetails login(String username, String password) {
        Optional<LoginDetails> ld = loginDetailsRepository.findByUsernameAndPassword(username, password);
        boolean correctLogin = ld.isPresent();
        if (correctLogin) {
            return ld.get();
        }
        return null;
    }

    public LoginDetails fetchLoginDetailsById(int id) {
        return loginDetailsRepository.findById(id);
    }
}
