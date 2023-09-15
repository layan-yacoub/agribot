package com.example.agribotproj.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import java.sql.Timestamp;

@Table(name = "subscription_plan")
@Getter
@Setter
@NoArgsConstructor
@Entity
@ToString
public class SubscriptionPlanDBO {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="subscription_plan_id")
    private Long subscriptionPlanID;
    @Column(name = "plan_name")
    private String planName;
    @Column(name = "plan_description")
    private String planDescription ;
    @Column(name = "duration_months")
    private Timestamp durationMonths;
    @Column(name="price")
    private double price;

    public SubscriptionPlanDBO(Long subscriptionPlanID, String planName, String planDescription, Timestamp durationMonths, double price) {
        this.subscriptionPlanID = subscriptionPlanID;
        this.planName = planName;
        this.planDescription = planDescription;
        this.durationMonths = durationMonths;
        this.price = price;
    }
}
