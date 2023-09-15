package com.example.agribotproj.service;

import com.example.agribotproj.domain.SubscriptionPlanDBO;
import com.example.agribotproj.domain.UserDBO;
import com.example.agribotproj.domain.UserSubscriptionDBO;
import com.example.agribotproj.repository.SubscriptionPlanJpaRepo;
import com.example.agribotproj.repository.UserJpaRepo;
import com.example.agribotproj.repository.UserSubscriptionJpaRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserSubscriptionService {
    private final UserSubscriptionJpaRepo userSubscriptionJpaRepo;
    private final UserJpaRepo userJpaRepo;
    private final SubscriptionPlanJpaRepo subscriptionPlanJpaRepo;

    public void AddSubPlan(Long userId, Long subscriptionPlanId) {
        UserSubscriptionDBO userSubPlan = new UserSubscriptionDBO();
        UserDBO user = userJpaRepo.findById(userId).orElse(null);
        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }
        userSubPlan.setUserDBO(user);
        SubscriptionPlanDBO subPlan = subscriptionPlanJpaRepo.findById(subscriptionPlanId).orElse(null);
        if (subPlan == null) {
            throw new IllegalArgumentException("Subscription Plan not found");
        }
        userSubPlan.setSubscriptionPlanDBO(subPlan);
        Timestamp currentTimestamp = new Timestamp(new Date().getTime());
        userSubPlan.setSubscriptionStartDate(currentTimestamp);
        userSubscriptionJpaRepo.save(userSubPlan);
    }


}
