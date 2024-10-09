package com.mark.autostock.controller;

import com.mark.autostock.domain.dto.request.SigninRequest;
import com.mark.autostock.domain.dto.request.SignupRequest;
import com.mark.autostock.service.impl.SecurityServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class SecurityController {
    private final SecurityServiceImpl securityServiceImpl;

    @PostMapping("/signup")
    ResponseEntity<?> signup(@Valid @RequestBody SignupRequest signupRequest) throws IOException {
        return securityServiceImpl.register(signupRequest);
    }

    @PostMapping("/signin")
    ResponseEntity<?> signin(@Valid @RequestBody SigninRequest signinRequest,
                             HttpServletResponse response) {
        return securityServiceImpl.login(signinRequest, response);
    }
    @PostMapping("/refresh_token")
    public ResponseEntity<?> refresh(HttpServletRequest request, HttpServletResponse response) {
        return securityServiceImpl.refresh(request, response);
    }
}
