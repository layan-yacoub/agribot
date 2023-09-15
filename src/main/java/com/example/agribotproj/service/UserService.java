package com.example.agribotproj.service;

import com.example.agribotproj.domain.UserDBO;
import com.example.agribotproj.repository.UserJpaRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserJpaRepo userJpaRepo;

    public boolean getAccountStatus(Long userId) {
        UserDBO user = userJpaRepo.findById(userId).orElse(null);
        if (user == null) {
            throw new IllegalArgumentException("Patient not found");
        }
        else return user.isAccountStatus();
    }


    public Optional<UserDBO> getUserById(Long userId) {
       return userJpaRepo.findById(userId);
    }
}

