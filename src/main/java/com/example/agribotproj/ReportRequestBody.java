package com.example.agribotproj;

import com.example.agribotproj.domain.UserDBO;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;
import org.springframework.web.bind.annotation.PathVariable;

import java.sql.Timestamp;

@Data
@Builder
public class ReportRequestBody {

    private Long userId;
    private String reportTitle;
    private String reportReason;
    private String adminName;
    private String adminReplyText;
    private boolean reportStatus;
}
