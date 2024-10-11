package com.mark.autostock.controller.impl;

import com.mark.autostock.controller.CrudControllerI;
import com.mark.autostock.domain.dto.request.SellRequest;
import com.mark.autostock.service.impl.SellServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/sell")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequiredArgsConstructor
public class SellController implements CrudControllerI<SellRequest, Long> {
    private final SellServiceImpl sellService;

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        try {
            return ResponseEntity.ok(sellService.getAll());
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody SellRequest req) {
        try {
            return ResponseEntity.ok(sellService.add(req));
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @PutMapping("/change/{id}")
    public ResponseEntity<?> change(@PathVariable Long id, @RequestBody SellRequest req) {
        try {
            return ResponseEntity.ok(sellService.change(id, req));
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            sellService.delete(id);
            return ResponseEntity.ok("Success deleted");
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }
}
