package com.example.agribotproj.controller;

import com.example.agribotproj.domain.SubscriptionPlanDBO;
import com.example.agribotproj.service.SubscriptionPlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "api/subPlan")
public class SubscriptionPlanController {
    private final SubscriptionPlanService subscriptionPlanService;

    @GetMapping()//get list of the ALL Subscription plans
    public ResponseEntity<List<SubscriptionPlanDBO>> getAllSubPlans() {
        List<SubscriptionPlanDBO> subPlans = subscriptionPlanService.getAllSubPlans();
        return ResponseEntity.ok(subPlans);

    }

}
