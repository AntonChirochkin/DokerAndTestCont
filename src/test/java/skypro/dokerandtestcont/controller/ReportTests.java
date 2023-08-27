package skypro.dokerandtestcont.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import skypro.dokerandtestcont.pojo.Employee;
import skypro.dokerandtestcont.pojo.Position;
import skypro.dokerandtestcont.pojo.Report;
import skypro.dokerandtestcont.repository.EmployeeRepository;
import skypro.dokerandtestcont.repository.PositionRepository;
import skypro.dokerandtestcont.repository.ReportRepository;
import skypro.dokerandtestcont.service.ReportService;

import java.util.List;


@SpringBootTest
@AutoConfigureMockMvc
@Testcontainers
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ReportTests {

    @Container
    private static final PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:latest")
            .withUsername("postgres")
            .withPassword("73aberiv");

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PositionRepository positionRepository;

    @Autowired
    private ReportService reportService;

    @Autowired
    private ReportRepository reportRepository;

    @DynamicPropertySource
    static void postgresProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgres::getJdbcUrl);
        registry.add("spring.datasource.username", postgres::getUsername);
        registry.add("spring.datasource.password", postgres::getPassword);
    }


    @Test
    @WithMockUser(username = "admin", roles = "ADMIN", password = "admin1234")
    void getReport() throws Exception {
        addEmployeeListInRepository();
        mockMvc.perform(post("/report/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value(1));
    }

    @Test
    @WithMockUser(username = "admin", roles = "ADMIN", password = "admin1234")
    void getReportById() throws Exception {
        addEmployeeListInRepository();
        Integer id = reportService.addReport();
        MvcResult result = mockMvc.perform(get("/report/{id}", id))
                .andExpect(status().isOk())
                .andReturn();
        byte[] resourceContent = result.getResponse().getContentAsByteArray();
        Report report = reportRepository.findById(id).orElse(null);
        String file = report.getFile();
        assertThat(resourceContent).isNotEmpty();
        assertThat(resourceContent).containsExactly(file.getBytes());
    }

    void addEmployeeListInRepository() {
        Position position = new Position(1, "position-1");
        Position position2 = new Position(2, "position-2");
        positionRepository.save(position);
        positionRepository.save(position2);
        List<Employee> employeeList = List.of(
                new Employee(1, "Ivan", 10000, 1, position),
                new Employee(2, "Inna", 20000, 2, position2),
                new Employee(3, "Anna", 30000, 3, position2)
        );
        employeeRepository.saveAll(employeeList);
    }
}


