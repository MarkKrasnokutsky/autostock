package com.mark.autostock.controller;

import com.mark.autostock.entity.AutomobileEntity;
import com.mark.autostock.repository.AutomobileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/auto")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequiredArgsConstructor
public class AutomobileController {
    private final AutomobileRepository automobileRepository;

    @GetMapping("/getAll")
    ResponseEntity<?> getAllAuto() {
        try {
            return ResponseEntity.ok(automobileRepository.findAll());
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @PostMapping("/add")
    ResponseEntity<?> addAuto(@RequestBody AutomobileEntity automobileEntity) {
        try {
            return ResponseEntity.ok(automobileRepository.save(automobileEntity));
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @PutMapping("/change/{id}")
    ResponseEntity<?> changeAuto(@PathVariable Long id, @RequestBody AutomobileEntity automobileEntity) {
        try {
            AutomobileEntity entity = automobileRepository.findById(id).get();
            entity.setType(automobileEntity.getType());
            entity.setFirm(automobileEntity.getFirm());
            entity.setModel(automobileEntity.getModel());
            entity.setColor(automobileEntity.getColor());
            entity.setYear(automobileEntity.getYear());
            entity.setVolEngine(automobileEntity.getVolEngine());
            entity.setPower(automobileEntity.getPower());
            entity.setMileage(automobileEntity.getMileage());
            entity.setCost(automobileEntity.getCost());
            entity.setStatus(automobileEntity.getStatus());
            return ResponseEntity.ok(automobileRepository.save(entity));
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<?> deleteAuto(@PathVariable Long id) {
        try {
            AutomobileEntity entity = automobileRepository.findById(id).get();
            automobileRepository.delete(entity);
            return ResponseEntity.ok("Success deleted");
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }
}
