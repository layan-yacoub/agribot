package com.example.agribotproj.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import java.sql.Timestamp;

@Table(name = "progress")
@Getter
@Setter
@NoArgsConstructor
@Entity
@ToString
public class ProgressDBO {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="progress_id")
    private Long progressId;
    //foreign key with the user table
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserDBO userDBO;
    @Column(name = "start_time")
    private Timestamp startTime;
    @Column(name = "end_time")
    private Timestamp endTime;
    @Column(name="task_status")
    private boolean taskStatus;
    @Column(name="battery_level")
    private int batteryLevel;
    @Column(name="weed_count")
    private int weedCount;
    @Column(name="no_weed_count")
    private int noWeedCount;
    @Column(name="remaining_chemicals")
    private double remainingChemicals;
    @Column(name="temperature")
    private double temperature;
    @Column(name="humidity")
    private double humidity;
    @Column(name="crop_healthy")
    private int cropHealthy;
    @Column(name="crop_light")
    private int cropLight;
    @Column(name="crop_early_blight")
    private int cropEarlyBlight;

    public ProgressDBO(Long progressId, UserDBO userDBO, Timestamp startTime, Timestamp endTime, boolean taskStatus, int batteryLevel, int weedCount, int noWeedCount, double remainingChemicals, double temperature, double humidity, int cropHealthy, int cropLight, int cropEarlyBlight) {
        this.progressId = progressId;
        this.userDBO = userDBO;
        this.startTime = startTime;
        this.endTime = endTime;
        this.taskStatus = taskStatus;
        this.batteryLevel = batteryLevel;
        this.weedCount = weedCount;
        this.noWeedCount = noWeedCount;
        this.remainingChemicals = remainingChemicals;
        this.temperature = temperature;
        this.humidity = humidity;
        this.cropHealthy = cropHealthy;
        this.cropLight = cropLight;
        this.cropEarlyBlight = cropEarlyBlight;
    }
}