package skypro.dokerandtestcont.service;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import skypro.dokerandtestcont.DTO.ReportWithPathDTO;

public interface ReportWithPathService {
    Integer addReportWithPath();
    ResponseEntity<Resource> getReportWithPathById(Integer id);
}
