package com.example.agribotproj.repository;
import com.example.agribotproj.domain.ReportDBO;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportJpaRepo extends JpaRepository<ReportDBO, Long> {



    List<ReportDBO> findAllByReportStatus(boolean b);

}

