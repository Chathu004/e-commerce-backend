package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.Login;
import org.example.dto.User;
import org.example.entity.UserEntity;
import org.example.service.LoginService;
import org.example.service.impl.UserServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
@CrossOrigin
public class UserController {
    final UserServiceImpl service;
    final LoginService loginService;

    @PostMapping("/add")
    public void addUser(@RequestBody User user){
        service.addUser(user);
        loginService.insertLoginData(new Login(user.getEmail(),user.getPassword()));
    }
    @GetMapping("/get")
    public Iterable<UserEntity> getUsers(){
        return service.getUsers();
    }
    @DeleteMapping("/remove/{id}")
    public String deleteUser(@PathVariable Long id){
        service.deleteUser(id);
        return "deleted user";
    }

}
