package com.example.agribotproj.controller;

import com.example.agribotproj.ReportRequestBody;
import com.example.agribotproj.domain.ReportDBO;
import com.example.agribotproj.domain.UserDBO;
import com.example.agribotproj.service.ReportNotFoundException;
import com.example.agribotproj.service.ReportService;
//import com.example.agribotproj.service.ReportServices;
import com.example.agribotproj.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "api/report")
public class ReportController {

    private final ReportService reportService;
    private final UserService userService;

    // save report
    @PostMapping("/save/{user_id}/{title}/{reason}/{reported}/{rep_text}")
    public ResponseEntity<HttpStatus> saveReport(@RequestBody ReportRequestBody reportRequestBody) {
        try {
            reportService.saveReport(reportRequestBody);
            return ResponseEntity.ok(HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();// Return HTTP 400 Bad Request
        }
    }

    //get list of the ALL reports includes that has been resolved
    @GetMapping("/AllReports")
    public ResponseEntity<List<ReportDBO>> getAllReports() {
        List<ReportDBO> reports = reportService.getAllReports();
        if (reports ==null)
            return (ResponseEntity<List<ReportDBO>>) ResponseEntity.noContent();
        return ResponseEntity.ok(reports);
    }

    //get list of all visible report [not resolved]
    @GetMapping("/notResolved/reports")
    public ResponseEntity<List<ReportDBO>> getAllVisibleReports() {
        List<ReportDBO> reports = reportService.getAllVisibleReports();
        return ResponseEntity.ok(reports);
    }

    //get content of specific report
    @GetMapping("/reports/{reportId}")
    public ResponseEntity<String> showReportById(@PathVariable("reportId") Long reportId) {
        try {
            ReportDBO report = reportService.getReportById(reportId);
            String content=  "The Title" + report.getReportTitle() +"\n The Reason of the Report : " +report.getReportReason()+"\n";
            return ResponseEntity.ok(content);
        } catch (ReportNotFoundException e) {
            return ResponseEntity.notFound().build(); // Return HTTP 404 Not Found
        }
    }

    //resolve report
    @PutMapping("/{report_id}/resolve")
    public ResponseEntity<HttpStatus> resolveReport(@PathVariable("report_id") Long reportId , @RequestParam String reply) {
        try {
            reportService.resolveReport(reportId , reply);
            return ResponseEntity.ok(HttpStatus.CREATED); // Return HTTP 200 OK
        } catch (ReportNotFoundException e) {
            return ResponseEntity.badRequest().build(); // Return HTTP 404 Not Found
        }
    }

    //delete report
    @DeleteMapping("/delete/{reportId}")
    public ResponseEntity<Void> deleteReport(@PathVariable("reportId") Long reportId) {
        try {
            reportService.deleteReport(reportId);
            return ResponseEntity.ok().build();
        } catch (ReportNotFoundException e) {
            return ResponseEntity.badRequest().build(); // Return HTTP 404 Not Found
        }
    }

}


