package com.mark.autostock.controller;

import com.mark.autostock.domain.dto.request.SigninRequest;
import com.mark.autostock.domain.dto.request.SignupRequest;
import com.mark.autostock.service.impl.SecurityServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
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

    @GetMapping("/role/get/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(securityServiceImpl.getRoleById(id));
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @GetMapping("/role/getAll")
    public ResponseEntity<?> getAllUsers() {
        try {
            return ResponseEntity.ok(securityServiceImpl.getAllRoles());
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }
}
