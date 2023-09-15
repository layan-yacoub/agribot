package com.example.agribotproj.controller;

import com.example.agribotproj.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "api/user")
public class UserController {

    private final UserService userService;
    @GetMapping("/{user_id}/status")
    public ResponseEntity<Boolean> getAccountStatus(@PathVariable("user_id") Long userId) {
        try {
            boolean status = userService.getAccountStatus(userId);
            return ResponseEntity.ok(status);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();// Return HTTP 400 Bad Request
        }
    }




}