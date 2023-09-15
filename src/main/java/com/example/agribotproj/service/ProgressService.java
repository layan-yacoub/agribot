package com.example.agribotproj.service;

import com.example.agribotproj.domain.ProgressDBO;
import com.example.agribotproj.repository.ProgressJpaRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Time;

@Service
@RequiredArgsConstructor
public class ProgressService {
    private final ProgressJpaRepo progressJpaRepo;

    public int getBatteryLevel(Long progressId) {
        ProgressDBO progress = progressJpaRepo.findById(progressId).orElse(null);
        if (progress == null) {
            throw new IllegalArgumentException("Progress not found");
        } else return progress.getBatteryLevel();
    }
    public double getSoilTemperature(Long progressId) {
        ProgressDBO progress = progressJpaRepo.findById(progressId).orElse(null);
        if (progress == null) {
            throw new IllegalArgumentException("Progress not found");
        } else return progress.getTemperature();
    }
    public double getSoilHumidity(Long progressId) {
        ProgressDBO progress = progressJpaRepo.findById(progressId).orElse(null);
        if (progress == null) {
            throw new IllegalArgumentException("Progress not found");
        } else return progress.getHumidity();
    }
    public boolean getSoilHealth(Long progressId) {
        ProgressDBO progress = progressJpaRepo.findById(progressId).orElse(null);
        if (progress == null) {
            throw new IllegalArgumentException("Progress not found");
        } else {
            return progress.getHumidity() >= .20 && progress.getHumidity() <= .60
                    && progress.getTemperature() >= 10 && progress.getTemperature() <= 24;
        }
    }
    public double getRemainingChemicals(Long progressId) {
        ProgressDBO progress = progressJpaRepo.findById(progressId).orElse(null);
        if (progress == null) {
            throw new IllegalArgumentException("Progress not found");
        } else return progress.getRemainingChemicals();
    }
    public void addTOWeedCounter(Long progressId) {
        ProgressDBO progress = progressJpaRepo.findById(progressId).orElse(null);
        if (progress == null) {
            throw new IllegalArgumentException("Progress not found");
        }
        else {
            int weed = progress.getWeedCount();
            progress.setWeedCount(weed+1);
            progressJpaRepo.save(progress);
        }

    }
    public void addTONoWeedCounter(Long progressId) {
        ProgressDBO progress = progressJpaRepo.findById(progressId).orElse(null);
        if (progress == null) {
            throw new IllegalArgumentException("Progress not found");
        }
        else {
            int noWeed = progress.getNoWeedCount();
            progress.setNoWeedCount(noWeed+1);
            progressJpaRepo.save(progress);
        }
    }
    public int getWeedCounter(Long progressId) {
        ProgressDBO progress = progressJpaRepo.findById(progressId).orElse(null);
        if (progress == null) {
            throw new IllegalArgumentException("Progress not found");
        } else return progress.getWeedCount();
    }
    public int getNoWeedCounter(Long progressId) {
        ProgressDBO progress = progressJpaRepo.findById(progressId).orElse(null);
        if (progress == null) {
            throw new IllegalArgumentException("Progress not found");
        } else return progress.getNoWeedCount();
    }
    public int getCropHealthy(Long progressId) {
        ProgressDBO progress = progressJpaRepo.findById(progressId).orElse(null);
        if (progress == null) {
            throw new IllegalArgumentException("Progress not found");
        } else return progress.getCropHealthy();
    }
    public int getCropLight(Long progressId) {
        ProgressDBO progress = progressJpaRepo.findById(progressId).orElse(null);
        if (progress == null) {
            throw new IllegalArgumentException("Progress not found");
        } else return progress.getCropLight();
    }
    public int getCropEarlyBlight(Long progressId) {
        ProgressDBO progress = progressJpaRepo.findById(progressId).orElse(null);
        if (progress == null) {
            throw new IllegalArgumentException("Progress not found");
        } else return progress.getCropEarlyBlight();
    }

}

