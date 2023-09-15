package com.example.agribotproj.repository;

import com.example.agribotproj.domain.ProgressDBO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.relational.core.sql.Select;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.YearMonth;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
@Repository
public interface ProgressJpaRepo extends JpaRepository<ProgressDBO, Long> {

    @Query("SELECT AVG(p.cropHealthy) " +
            "FROM ProgressDBO  p " +
            "WHERE p.userDBO = :userId " +
            "AND MONTH(p.endTime) = :month")
    Double findAverageCropHealthyForUserAndMonth(
            @Param("userId") Long userId,
            @Param("month") Month month
    );

    @Query("SELECT AVG(p.cropHealthy) " +
            "FROM ProgressDBO p " +
            "WHERE p.userDBO = :userId " +
            "AND YEAR(p.endTime) = :year")
    Double findAverageCropHealthyForUserAndYear(
            @Param("userId") Long userId,
            @Param("year") Year year
    );

    @Query("SELECT AVG(p.cropHealthy) " +
            "FROM ProgressDBO p " +
            "WHERE p.userDBO = :userId " +
            "AND DATE(p.endTime) = :currentDate")
    Double findAverageCropHealthyForUserAndToday(
            @Param("userId") Long userId,
            @Param("currentDate") LocalDate currentDate
    );

    // LightCrop AVG
    @Query("SELECT AVG(p.cropLight) " +
            "FROM ProgressDBO p " +
            "WHERE p.userDBO = :userId " +
            "AND DATE(p.endTime) = :currentDate")
    Double findAverageTodayLightCrop( @Param("userId") Long userId,
                                      @Param("currentDate") LocalDate currentDate);
    @Query("SELECT AVG(p.cropLight) " +
            "FROM ProgressDBO  p " +
            "WHERE p.userDBO = :userId " +
            "AND MONTH(p.endTime) = :month")
    Double findAverageThisMonthLightCrop( @Param("userId") Long userId,
                                          @Param("month") Month month);
    @Query("SELECT AVG(p.cropLight) " +
            "FROM ProgressDBO p " +
            "WHERE p.userDBO = :userId " +
            "AND YEAR(p.endTime) = :year")
    Double findAverageThisYearLightCrop( @Param("userId") Long userId,
                                         @Param("year") Year year);
    //cropEarlyBlight
    @Query("SELECT AVG(p.cropEarlyBlight) " +
            "FROM ProgressDBO p " +
            "WHERE p.userDBO = :userId " +
            "AND DATE(p.endTime) = :currentDate")
    Double findAverageTodayCropEarlyBlight(@Param("userId") Long userId,
                                           @Param("currentDate") LocalDate currentDate);
    @Query("SELECT AVG(p.cropEarlyBlight) " +
            "FROM ProgressDBO  p " +
            "WHERE p.userDBO = :userId " +
            "AND MONTH(p.endTime) = :month")
    Double findAverageThisMonthCropEarlyBlight(@Param("userId") Long userId,
                                               @Param("month") Month month);
    @Query("SELECT AVG(p.cropEarlyBlight) " +
            "FROM ProgressDBO p " +
            "WHERE p.userDBO = :userId " +
            "AND YEAR(p.endTime) = :year")
    Double findAverageThisYearCropEarlyBlight(@Param("userId") Long userId,
                                              @Param("year") Year year);

    //Humidity
    @Query("SELECT AVG(p.humidity) " +
            "FROM ProgressDBO p " +
            "WHERE p.userDBO = :userId " +
            "AND DATE(p.endTime) = :currentDate")
    Double findAverageTodayHumidity(@Param("userId") Long userId,
                                    @Param("currentDate") LocalDate currentDate);
    @Query("SELECT AVG(p.humidity) " +
            "FROM ProgressDBO  p " +
            "WHERE p.userDBO = :userId " +
            "AND MONTH(p.endTime) = :month")
    Double findAverageThisMonthHumidity(@Param("userId") Long userId,
                                        @Param("month") Month month);
    @Query("SELECT AVG(p.humidity) " +
            "FROM ProgressDBO p " +
            "WHERE p.userDBO = :userId " +
            "AND YEAR(p.endTime) = :year")
    Double findAverageThisYearHumidity(@Param("userId") Long userId,
                                       @Param("year") Year year);

    //temperature
    @Query("SELECT AVG(p.temperature) " +
            "FROM ProgressDBO p " +
            "WHERE p.userDBO = :userId " +
            "AND DATE(p.endTime) = :currentDate")
    Double findAverageTodayTemperature(@Param("userId") Long userId,
                                       @Param("currentDate") LocalDate currentDate);
    @Query("SELECT AVG(p.temperature) " +
            "FROM ProgressDBO  p " +
            "WHERE p.userDBO = :userId " +
            "AND MONTH(p.endTime) = :month")
    Double findAverageThisMonthTemperature(@Param("userId") Long userId,
                                           @Param("month") Month month);
    @Query("SELECT AVG(p.temperature) " +
            "FROM ProgressDBO p " +
            "WHERE p.userDBO = :userId " +
            "AND YEAR(p.endTime) = :year")
    Double findAverageThisYearTemperature(@Param("userId") Long userId,
                                          @Param("year") Year year);


}
