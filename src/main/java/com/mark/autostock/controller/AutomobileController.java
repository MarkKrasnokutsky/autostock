package com.mark.autostock.controller;

import com.mark.autostock.entity.AutomobileEntity;
import com.mark.autostock.service.impl.AutomobileServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auto")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequiredArgsConstructor
public class AutomobileController {
    private final AutomobileServiceImpl automobileService;

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        try {
            return ResponseEntity.ok(automobileService.getAll());
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody AutomobileEntity automobileEntity) {
        try {
            return ResponseEntity.ok(automobileService.add(automobileEntity));
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @PutMapping("/change/{id}")
    public ResponseEntity<?> change(@PathVariable Long id, @RequestBody AutomobileEntity automobileEntity) {
        try {
            return ResponseEntity.ok(automobileService.change(id, automobileEntity));
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            automobileService.delete(id);
            return ResponseEntity.ok("Success deleted");
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }
}
