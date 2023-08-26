package skypro.dokerandtestcont.service;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import skypro.dokerandtestcont.DTO.ReportDTO;


public interface ReportService {
    Integer addReport();
    ResponseEntity<Resource> getReportById(Integer id);
}
