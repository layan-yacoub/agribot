package com.example.agribotproj.service;

import com.example.agribotproj.domain.SubscriptionPlanDBO;
import com.example.agribotproj.repository.SubscriptionPlanJpaRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubscriptionPlanService {
    private final SubscriptionPlanJpaRepo subscriptionPlanJpaRepo;

    public List<SubscriptionPlanDBO> getAllSubPlans() {
        return subscriptionPlanJpaRepo.findAll();
    }

}
