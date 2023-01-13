package com.example.Employee.api.Daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginDetailsRepository extends JpaRepository<LoginDetails, Integer> {
    Optional<LoginDetails> findByUsernameAndPassword(String username, String password);

    LoginDetails findById(int id);
}
