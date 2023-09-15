package com.example.agribotproj.repository;

import com.example.agribotproj.domain.UserSubscriptionDBO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSubscriptionJpaRepo extends JpaRepository<UserSubscriptionDBO, Long> {
}

