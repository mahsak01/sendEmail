package com.example.sendemail.Repositorys;

import com.example.sendemail.Models.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<Email, Long> {

    Email findByUsername(String username);
}
