package com.example.agribotproj.repository;

import com.example.agribotproj.domain.UserDBO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJpaRepo extends JpaRepository<UserDBO, Long> {
}