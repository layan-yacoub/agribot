package com.example.agribotproj.service;

import com.example.agribotproj.domain.UserDBO;
import com.example.agribotproj.repository.ProgressJpaRepo;
import com.example.agribotproj.repository.UserJpaRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;


@Service
@RequiredArgsConstructor
public class SummaryService {
    private final UserJpaRepo userJpaRepo;
    private final ProgressJpaRepo progressJpaRepo;

    // HealthyCrop
    public double getMonthCropHealthy(Long userId, Month month) {
        UserDBO user = userJpaRepo.findById(userId).orElse(null);
        if (user == null) {
            throw new IllegalArgumentException("User not found");
        } else
           return progressJpaRepo.findAverageCropHealthyForUserAndMonth(userId, month);
    }

    public Double getAverageCropHealthyForUserAndYear(Long userId, Year year) {
        UserDBO user = userJpaRepo.findById(userId).orElse(null);
        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }
        return progressJpaRepo.findAverageCropHealthyForUserAndYear(userId, year);
    }

    public double getAverageCropHealthyForUserAndToday(Long userId, LocalDate currentDate) {
        UserDBO user = userJpaRepo.findById(userId).orElse(null);
        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }
        return progressJpaRepo.findAverageCropHealthyForUserAndToday(userId, currentDate);
    }

    //LightCrop
    public double getAverageTodayLightCrop(Long userId, LocalDate currentDate) {
        UserDBO user = userJpaRepo.findById(userId).orElse(null);
        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }
        return progressJpaRepo.findAverageTodayLightCrop(userId, currentDate);
    }

    public double getAverageThisMonthLightCrop(Long userId, Month month) {
        UserDBO user = userJpaRepo.findById(userId).orElse(null);
        if (user == null) {
            throw new IllegalArgumentException("User not found");
        } else
            return progressJpaRepo.findAverageThisMonthLightCrop(userId, month);
    }

    public double getAverageThisYearLightCrop(Long userId, Year year) {
        UserDBO user = userJpaRepo.findById(userId).orElse(null);
        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }
        return progressJpaRepo.findAverageThisYearLightCrop(userId, year);
    }

    //cropEarlyBlight

    public double getAverageTodayCropEarlyBlight(Long userId, LocalDate currentDate) {
        UserDBO user = userJpaRepo.findById(userId).orElse(null);
        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }
        return progressJpaRepo.findAverageTodayCropEarlyBlight(userId, currentDate);
    }

    public double getAverageThisMonthCropEarlyBlight(Long userId, Month month) {
        UserDBO user = userJpaRepo.findById(userId).orElse(null);
        if (user == null) {
            throw new IllegalArgumentException("User not found");
        } else
            return progressJpaRepo.findAverageThisMonthCropEarlyBlight(userId, month);
    }

    public double getAverageThisYearCropEarlyBlight(Long userId, Year year) {
        UserDBO user = userJpaRepo.findById(userId).orElse(null);
        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }
        return progressJpaRepo.findAverageThisYearCropEarlyBlight(userId, year);
    }

    //Humidity
    public double getAverageTodayHumidity(Long userId, LocalDate currentDate) {
        UserDBO user = userJpaRepo.findById(userId).orElse(null);
        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }
        return progressJpaRepo.findAverageTodayHumidity(userId, currentDate);
    }
    public double getAverageThisMonthHumidity(Long userId, Month month) {
            UserDBO user = userJpaRepo.findById(userId).orElse(null);
            if (user == null) {
                throw new IllegalArgumentException("User not found");
            } else
                return progressJpaRepo.findAverageThisMonthHumidity(userId, month);

        }
    public double getAverageThisYearHumidity(Long userId, Year year) {
        UserDBO user = userJpaRepo.findById(userId).orElse(null);
        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }
        return progressJpaRepo.findAverageThisYearHumidity(userId, year);
    }

    //temperature
    public double getAverageTodayTemperature(Long userId, LocalDate currentDate) {
        UserDBO user = userJpaRepo.findById(userId).orElse(null);
        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }
        return progressJpaRepo.findAverageTodayTemperature(userId, currentDate);
    }
    public double getAverageThisMonthTemperature(Long userId, Month month) {
        UserDBO user = userJpaRepo.findById(userId).orElse(null);
        if (user == null) {
            throw new IllegalArgumentException("User not found");
        } else
            return progressJpaRepo.findAverageThisMonthTemperature(userId, month);

    }
    public double getAverageThisYearTemperature(Long userId, Year year) {
        UserDBO user = userJpaRepo.findById(userId).orElse(null);
        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }
        return progressJpaRepo.findAverageThisYearTemperature(userId, year);
    }

}

