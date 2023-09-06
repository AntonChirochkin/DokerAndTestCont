package skypro.dokerandtestcont.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import skypro.dokerandtestcont.DTO.ReportWithPathDTO;
import skypro.dokerandtestcont.service.EmployeeService;
import skypro.dokerandtestcont.service.ReportWithPathService;

import java.io.*;
import java.nio.file.*;

@RestController
@RequestMapping("/reportWithPath")
public class ReportWithPathController {
    private final ReportWithPathService reportWithPathService;
    private final EmployeeService employeeService;

    public ReportWithPathController(ReportWithPathService reportWithPathService, EmployeeService employeeService) {
        this.reportWithPathService = reportWithPathService;
        this.employeeService = employeeService;
    }

    @PostMapping("/")
    public Integer getReport() {
        return reportWithPathService.addReportWithPath();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<Resource> getReportById(@PathVariable Integer id) {
        return reportWithPathService.getReportWithPathById(id);
    }
}
