package com.example.agribotproj.controller;

import com.example.agribotproj.service.ProgressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "api/progress")
public class ProgressController {

    private final ProgressService progressService;
    @GetMapping("/{progress_id}/battery")
    public ResponseEntity<Integer> getBatteryLevel(@PathVariable("progress_id") Long progressId) {
        try {
            int battery = progressService.getBatteryLevel(progressId);
            return ResponseEntity.ok(battery);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();// Return HTTP 400 Bad Request
        }
    }
    @GetMapping("/{progress_id}/soilTemperature")
    public ResponseEntity<Double> getSoilTemperature(@PathVariable("progress_id") Long progressId) {
        try {
            double temperature = progressService.getSoilTemperature(progressId);
            return ResponseEntity.ok(temperature);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();// Return HTTP 400 Bad Request
        }
    }
    @GetMapping("/{progress_id}/soilHumidity")
    public ResponseEntity<Double> getSoilHumidity(@PathVariable("progress_id") Long progressId) {
        try {
            double humidity = progressService.getSoilHumidity(progressId);
            return ResponseEntity.ok(humidity);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();// Return HTTP 400 Bad Request
        }
    }
    @GetMapping("/{progress_id}/soilHealth")
    public ResponseEntity<Boolean> getSoilHealth(@PathVariable("progress_id") Long progressId) {
        try {
            boolean soilHealth = progressService.getSoilHealth(progressId);
            return ResponseEntity.ok(soilHealth);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();// Return HTTP 400 Bad Request
        }
    }
    @GetMapping("/{progress_id}/remainingChemicals")
    public ResponseEntity<Double> getRemainingChemicals(@PathVariable("progress_id") Long progressId) {
        try {
            double remainingChemicals = progressService.getRemainingChemicals(progressId);
            return ResponseEntity.ok(remainingChemicals);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();// Return HTTP 400 Bad Request
        }
    }
    @PutMapping("/{progress_id}/weedCounter")
    public ResponseEntity<?> weedCounter(@PathVariable("progress_id") Long progressId) {
        try {
           progressService.addTOWeedCounter(progressId);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();// Return HTTP 400 Bad Request
        }
    }
    @PutMapping("/{progress_id}/noWeedCounter")
    public ResponseEntity<?> noWeedCounter(@PathVariable("progress_id") Long progressId) {
        try {
            progressService.addTONoWeedCounter(progressId);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();// Return HTTP 400 Bad Request
        }
    }
    @GetMapping("/{progress_id}/weedCounter")
    public ResponseEntity<Integer> getWeedCounter(@PathVariable("progress_id") Long progressId) {
        try {
            int weedCounter = progressService.getWeedCounter(progressId);
            return ResponseEntity.ok(weedCounter);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();// Return HTTP 400 Bad Request
        }
    }
    @GetMapping("/{progress_id}/noWeedCounter")
    public ResponseEntity<Integer> getNoWeedCounter(@PathVariable("progress_id") Long progressId) {
        try {
            int noWeedCounter = progressService.getNoWeedCounter(progressId);
            return ResponseEntity.ok(noWeedCounter);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();// Return HTTP 400 Bad Request
        }
    }
    @GetMapping("/{progress_id}/cropHealthy")
    public ResponseEntity<Integer> getCropHealthy(@PathVariable("progress_id") Long progressId) {
        try {
            int cropHealthy = progressService.getCropHealthy(progressId);
            return ResponseEntity.ok(cropHealthy);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();// Return HTTP 400 Bad Request
        }
    }
    @GetMapping("/{progress_id}/cropLight")
    public ResponseEntity<Integer> getCropLight(@PathVariable("progress_id") Long progressId) {
        try {
            int cropLight = progressService.getCropLight(progressId);
            return ResponseEntity.ok(cropLight);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();// Return HTTP 400 Bad Request
        }
    }
    @GetMapping("/{progress_id}/cropEarlyBlight")
    public ResponseEntity<Integer> getCropEarlyBlight(@PathVariable("progress_id") Long progressId) {
        try {
            int cropEarlyBlight = progressService.getCropEarlyBlight(progressId);
            return ResponseEntity.ok(cropEarlyBlight);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();// Return HTTP 400 Bad Request
        }
    }

}
