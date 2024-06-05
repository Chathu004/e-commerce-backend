package org.example.service;

import org.example.dto.Login;

public interface LoginService {
    void insertLoginData(Login login);
    Boolean validateLogin(Login login);
}
