package com.mark.autostock.controller;

import com.mark.autostock.repository.AutomobileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auto")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequiredArgsConstructor
public class AutomobileController {
    private final AutomobileRepository automobileRepository;

    @GetMapping("/getAll")
    ResponseEntity<?> getStocks() {
        try {
            return ResponseEntity.ok(automobileRepository.findAll());
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }
}
