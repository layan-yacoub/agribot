package com.example.agribotproj.domain;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Table(name = "report")
@Getter
@Setter
@NoArgsConstructor
@Entity
@ToString
public class ReportDBO {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="report_id")
    private Long reportId;

    //foreign key with the user table
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserDBO userDBO;

    @Column(name = "report_time")
    private Timestamp reportTime;
    @Column(name = "report_title")
    private String reportTitle;
    @Column(name = "report_reason")
    private String reportReason;

    @Column(name="admin_name")
    private String adminName;
    @Column(name="admin_reply_text")
    private String adminReplyText;
    @Column(name="report_status")
    private boolean reportStatus;

    public ReportDBO( UserDBO userDBO, Timestamp reportTime, String reportTitle, String reportReason, String adminName, String adminReplyText, boolean reportStatus) {
        this.userDBO = userDBO;
        this.reportTime = reportTime;
        this.reportTitle = reportTitle;
        this.reportReason = reportReason;
        this.adminName = adminName;
        this.adminReplyText = adminReplyText;
        this.reportStatus = reportStatus;
    }



}
