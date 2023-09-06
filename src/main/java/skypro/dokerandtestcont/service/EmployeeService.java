package skypro.dokerandtestcont.service;

import skypro.dokerandtestcont.DTO.EmployeeFullInfo;
import org.springframework.web.multipart.MultipartFile;
import skypro.dokerandtestcont.DTO.EmployeeDTO;
import skypro.dokerandtestcont.DTO.EmployeeReport;
import java.util.List;

public interface EmployeeService {
    List<EmployeeFullInfo> getAllEmployees();

    int getSumSalary();

    EmployeeFullInfo getMaxSalary();

    EmployeeFullInfo getMinSalary();

    List<EmployeeFullInfo> getEmployeeWithSalaryAboveAverage();

    EmployeeDTO getEmployeeById(Integer id);

    List<EmployeeFullInfo> getEmployeesWithSalaryHigherThan(Integer compareSalary);

    void deleteEmployeeById(Integer id);

    void editEmployee(EmployeeDTO employeeDTO);
    void addEmployee(EmployeeDTO employeeDTO);
    EmployeeDTO getTheHighestSalary();

    List<EmployeeFullInfo> getEmployeeByPosition(Integer position);

    List<EmployeeDTO> getEmployeeWithPaging(Integer page);
    EmployeeFullInfo getEmployeeByIdFullInfo(Integer id);

    List<EmployeeReport> getReport();

    EmployeeDTO uploadEmployeeFromFile(MultipartFile file);

    void addEmployeeFromFile(MultipartFile file);
}
