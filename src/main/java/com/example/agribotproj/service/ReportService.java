package com.example.agribotproj.service;

import com.example.agribotproj.ReportRequestBody;
import com.example.agribotproj.domain.ReportDBO;
import com.example.agribotproj.domain.UserDBO;
import com.example.agribotproj.repository.ReportJpaRepo;
import com.example.agribotproj.repository.UserJpaRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReportService {
    private final ReportJpaRepo reportJpaRepo;
    private final UserService userService;
    private final UserJpaRepo userJpaRepo;

    //save report
    public void saveReport(ReportRequestBody report) {
        UserDBO userDBO = userJpaRepo.findById(report.getUserId()).orElse(null);

        if (userDBO == null) {
            throw new IllegalArgumentException("User not found");
        } else {
            ReportDBO newReport = new ReportDBO();

            newReport.setUserDBO(userDBO);
            newReport.setReportTitle(report.getReportTitle()); // Set title field to the value from the path variable
            newReport.setReportReason(report.getReportReason()); // Set reason field to the value from the path variable
            newReport.setAdminName("Admin"); // Assuming you want to set admin_id to a constant value (2)
            newReport.setAdminReplyText("");
            Timestamp currentTimestamp = new Timestamp(new Date().getTime());
            newReport.setReportTime(currentTimestamp); // Set the ReportTime field to the current timestamp
            newReport.setReportStatus(true);
            reportJpaRepo.save(newReport);
        }
    }

    // view all reports as a list
    public List<ReportDBO> getAllReports() {
        return reportJpaRepo.findAll();
    }

    public List<ReportDBO> getAllVisibleReports() {
        return reportJpaRepo.findAllByReportStatus(true);
    }

    public void resolveReport(Long reportId , String reply) {

        ReportDBO report = reportJpaRepo.findById(reportId).orElse(null);
        if (report == null ) {
            // Handle case where report with the given ID is not found
            throw new IllegalArgumentException("Report not found with ID: " + reportId);
        } else {
            report.setAdminReplyText(reply);
            report.setReportStatus(false);
            reportJpaRepo.save(report);

        }
    }

    public void save(ReportDBO report) {
        reportJpaRepo.save(report);
    }

    public ReportDBO getReportById(Long reportId) {
        ReportDBO report = reportJpaRepo.findById(reportId).orElse(null);
        if (reportJpaRepo.findById(reportId).isEmpty()) {
            throw new IllegalArgumentException("Report not found with ID: " + reportId);
        } else {
            return report;
        }}

        public void deleteReport (Long reportId){
            if (reportJpaRepo.existsById(reportId)) {
                reportJpaRepo.deleteById(reportId);
            } else {
                throw new ReportNotFoundException("Report not found with ID: " + reportId);
            }
        }


    }

