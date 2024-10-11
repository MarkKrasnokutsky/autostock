package com.mark.autostock.controller.impl;

import com.mark.autostock.controller.CrudControllerI;
import com.mark.autostock.domain.dto.request.AutomobileRequest;
import com.mark.autostock.service.impl.AutomobileServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auto")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequiredArgsConstructor
public class AutomobileController implements CrudControllerI<AutomobileRequest, Long> {
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
    public ResponseEntity<?> add(@RequestBody AutomobileRequest req) {
        try {
            return ResponseEntity.ok(automobileService.add(req));
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @PutMapping("/change/{id}")
    public ResponseEntity<?> change(@PathVariable Long id, @RequestBody AutomobileRequest req) {
        try {
            return ResponseEntity.ok(automobileService.change(id, req));
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
