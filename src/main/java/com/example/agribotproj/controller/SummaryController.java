package com.example.agribotproj.controller;

import com.example.agribotproj.service.ProgressService;
import com.example.agribotproj.service.SummaryService;
import com.example.agribotproj.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "api/summary")
public class SummaryController {
    private final ProgressService progressService;
    private final UserService userService;
    private final SummaryService summaryService;

    //healthyCrop summary today-thisMonth-thisYear
    @GetMapping("/{user_id}/healthyCrop/today")
    public ResponseEntity<Double> getAverageTodayCropHealthy(@PathVariable("user_id") Long userId) {
        try {
            LocalDate currentDate = LocalDate.now();
            double healthyCrop = summaryService.getAverageCropHealthyForUserAndToday(userId, currentDate);
            return ResponseEntity.ok(healthyCrop);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();// Return HTTP 400 Bad Request
        }
    }
    @GetMapping("/{user_id}/healthyCrop/thisMonth")
    public ResponseEntity<Double> getMonthCropHealthy(@PathVariable("user_id") Long userId) {

        try {
            LocalDate currentDate = LocalDate.now();
            Month month = currentDate.getMonth();
            double healthyCrop = summaryService.getMonthCropHealthy(userId,month);
            return ResponseEntity.ok(healthyCrop);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();// Return HTTP 400 Bad Request
        }
    }
    @GetMapping("/{user_id}/healthyCrop/thisYear")
    public ResponseEntity<Double> getAverageYearCropHealthy(@PathVariable("user_id") Long userId) {
        try {
            LocalDate currentDate = LocalDate.now();
            Year year = Year.of(currentDate.getYear());
            double healthyCrop = summaryService.getAverageCropHealthyForUserAndYear(userId, year);
            return ResponseEntity.ok(healthyCrop);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();// Return HTTP 400 Bad Request
        }
    }

    //LightCrop summary
    @GetMapping("/{user_id}/lightCrop/today")
    public ResponseEntity<Double> getAverageTodayLightCrop(@PathVariable("user_id") Long userId) {
        try {
            LocalDate currentDate = LocalDate.now();
            double lightCrop = summaryService.getAverageTodayLightCrop(userId, currentDate);
            return ResponseEntity.ok(lightCrop);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();// Return HTTP 400 Bad Request
        }
    }
    @GetMapping("/{user_id}/lightCrop/thisMonth")
    public ResponseEntity<Double> getAverageThisMonthLightCrop(@PathVariable("user_id") Long userId) {

        try {
            LocalDate currentDate = LocalDate.now();
            Month month = currentDate.getMonth();
            double lightCrop = summaryService.getAverageThisMonthLightCrop(userId,month);
            return ResponseEntity.ok(lightCrop);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();// Return HTTP 400 Bad Request
        }
    }
    @GetMapping("/{user_id}/lightCrop/thisYear")
    public ResponseEntity<Double> getAverageThisYearLightCrop(@PathVariable("user_id") Long userId) {
        try {
            LocalDate currentDate = LocalDate.now();
            Year year = Year.of(currentDate.getYear());
            double lightCrop = summaryService.getAverageThisYearLightCrop(userId, year);
            return ResponseEntity.ok(lightCrop);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();// Return HTTP 400 Bad Request
        }
    }

    //cropEarlyBlight
    @GetMapping("/{user_id}/cropEarlyBlight/today")
    public ResponseEntity<Double> getAverageTodayCropEarlyBlight(@PathVariable("user_id") Long userId) {
        try {
            LocalDate currentDate = LocalDate.now();
            double cropEarlyBlight = summaryService.getAverageTodayCropEarlyBlight(userId, currentDate);
            return ResponseEntity.ok(cropEarlyBlight);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();// Return HTTP 400 Bad Request
        }
    }
    @GetMapping("/{user_id}/cropEarlyBlight/thisMonth")
    public ResponseEntity<Double> getAverageThisMonthCropEarlyBlight(@PathVariable("user_id") Long userId) {

        try {
            LocalDate currentDate = LocalDate.now();
            Month month = currentDate.getMonth();
            double cropEarlyBlight = summaryService.getAverageThisMonthCropEarlyBlight(userId,month);
            return ResponseEntity.ok(cropEarlyBlight);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();// Return HTTP 400 Bad Request
        }
    }
    @GetMapping("/{user_id}/cropEarlyBlight/thisYear")
    public ResponseEntity<Double> getAverageThisYearCropEarlyBlight(@PathVariable("user_id") Long userId) {
        try {
            LocalDate currentDate = LocalDate.now();
            Year year = Year.of(currentDate.getYear());
            double cropEarlyBlight = summaryService.getAverageThisYearCropEarlyBlight(userId, year);
            return ResponseEntity.ok(cropEarlyBlight);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();// Return HTTP 400 Bad Request
        }
    }

    //humidity

    @GetMapping("/{user_id}/humidity/today")
    public ResponseEntity<Double> getAverageTodayHumidity(@PathVariable("user_id") Long userId) {
        try {
            LocalDate currentDate = LocalDate.now();
            double humidity = summaryService.getAverageTodayHumidity(userId, currentDate);
            return ResponseEntity.ok(humidity);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();// Return HTTP 400 Bad Request
        }
    }
    @GetMapping("/{user_id}/humidity/thisMonth")
    public ResponseEntity<Double> getAverageThisMonthHumidity(@PathVariable("user_id") Long userId) {

        try {
            LocalDate currentDate = LocalDate.now();
            Month month = currentDate.getMonth();
            double humidity = summaryService.getAverageThisMonthHumidity(userId,month);
            return ResponseEntity.ok(humidity);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();// Return HTTP 400 Bad Request
        }
    }
    @GetMapping("/{user_id}/humidity/thisYear")
    public ResponseEntity<Double> getAverageThisYearHumidity(@PathVariable("user_id") Long userId) {
        try {
            LocalDate currentDate = LocalDate.now();
            Year year = Year.of(currentDate.getYear());
            double humidity = summaryService.getAverageThisYearHumidity(userId, year);
            return ResponseEntity.ok(humidity);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();// Return HTTP 400 Bad Request
        }
    }

   //temperature
   @GetMapping("/{user_id}/temperature/today")
   public ResponseEntity<Double> getAverageTodayTemperature(@PathVariable("user_id") Long userId) {
       try {
           LocalDate currentDate = LocalDate.now();
           double temperature = summaryService.getAverageTodayTemperature(userId, currentDate);
           return ResponseEntity.ok(temperature);
       } catch (IllegalArgumentException e) {
           return ResponseEntity.badRequest().build();// Return HTTP 400 Bad Request
       }
   }
    @GetMapping("/{user_id}/temperature/thisMonth")
    public ResponseEntity<Double> getAverageThisMonthTemperature(@PathVariable("user_id") Long userId) {

        try {
            LocalDate currentDate = LocalDate.now();
            Month month = currentDate.getMonth();
            double temperature = summaryService.getAverageThisMonthTemperature(userId,month);
            return ResponseEntity.ok(temperature);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();// Return HTTP 400 Bad Request
        }
    }
    @GetMapping("/{user_id}/temperature/thisYear")
    public ResponseEntity<Double> getAverageThisYeaTemperature(@PathVariable("user_id") Long userId) {
        try {
            LocalDate currentDate = LocalDate.now();
            Year year = Year.of(currentDate.getYear());
            double temperature = summaryService.getAverageThisYearTemperature(userId, year);
            return ResponseEntity.ok(temperature);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();// Return HTTP 400 Bad Request
        }
    }
}
