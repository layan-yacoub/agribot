package com.example.agribotproj.controller;

import com.example.agribotproj.service.UserSubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "api/userSubPlan")
public class UserSubscriptionController {
    private final UserSubscriptionService userSubscriptionPlanService;

    @PostMapping("/{user_id}/{subscription_plan_id}")
    public ResponseEntity<?> AddSubPlan(@PathVariable Long user_id, @PathVariable Long subscription_plan_id) {

        try {
            userSubscriptionPlanService.AddSubPlan(user_id,subscription_plan_id);
            return ResponseEntity.ok("");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();// Return HTTP 400 Bad Request
        }}





    }
