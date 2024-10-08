package com.mark.autostock.service;


import com.mark.autostock.dto.request.SigninRequest;
import com.mark.autostock.dto.request.SignupRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

public interface SecurityServiceI {
    ResponseEntity<?> register(SignupRequest signupRequest) throws IOException;
    ResponseEntity<?> login(SigninRequest signinRequest, HttpServletResponse response);
    ResponseEntity<?> refresh(HttpServletRequest request, HttpServletResponse response);
}
