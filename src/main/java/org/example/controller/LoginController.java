package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.Login;
import org.example.repository.LoginRepository;
import org.example.service.LoginService;
import org.example.service.impl.LoginServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/login")
public class LoginController {
    final LoginRepository repository;
    final LoginServiceImpl service;
    @PostMapping("/request-login")
    public Boolean validateLogin(@RequestBody Login login){
        return service.validateLogin(login);
    }


}
