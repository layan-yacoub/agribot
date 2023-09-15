package com.example.agribotproj.domain;


import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.time.LocalDate;

@Table(name = "user_subscription")
@Getter
@Setter
@NoArgsConstructor
@Entity
@ToString
public class UserSubscriptionDBO {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id")
    private Long id;
    //foreign key with the user table
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserDBO userDBO;

    @Column(name = "subscription_start_date" )
    private Timestamp subscriptionStartDate;

    @Column(name = "subscription_end_date" )
    private Timestamp subscriptionEndDate;

    //foreign key with the user table
    @ManyToOne
    @JoinColumn(name = "subscription_plan_id")
    private SubscriptionPlanDBO subscriptionPlanDBO;

    public UserSubscriptionDBO(Long id, UserDBO userDBO, Timestamp subscriptionStartDate,  SubscriptionPlanDBO subscriptionPlanDBO) {
        this.id = id;
        this.userDBO = userDBO;
        this.subscriptionStartDate = subscriptionStartDate;
        this.subscriptionPlanDBO = subscriptionPlanDBO;

        // Calculate the subscription start date (assuming it's the current date)
        this.subscriptionStartDate = Timestamp.valueOf(LocalDate.now().atStartOfDay());

        // Calculate the subscription end date based on durationMonths
        this.subscriptionEndDate = calculateSubscriptionEndDate(subscriptionPlanDBO.getDurationMonths());
    }

    private Timestamp calculateSubscriptionEndDate(Timestamp durationMonths) {
        LocalDate startDate = subscriptionStartDate.toLocalDateTime().toLocalDate();

        // Convert durationMonths to a number of months
        int monthsToAdd = durationMonths.toLocalDateTime().getMonthValue();

        // Calculate the end date by adding months to the start date
        LocalDate endDate = startDate.plusMonths(monthsToAdd);

        return Timestamp.valueOf(endDate.atStartOfDay());
    }

}