package com.example.agribotproj.repository;


import com.example.agribotproj.domain.SubscriptionPlanDBO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionPlanJpaRepo extends JpaRepository<SubscriptionPlanDBO, Long> {
}
