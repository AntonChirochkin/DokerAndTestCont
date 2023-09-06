package skypro.dokerandtestcont.DTO;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
@EqualsAndHashCode
public class EmployeeReport implements Serializable {

    private int department;
    private Long countOfEmployees;
    private int minSalary;
    private int maxSalary;
    private double averageSalary;

    public EmployeeReport(int department, Long countOfEmployees, int minSalary, int maxSalary, double averageSalary) {
        this.department = department;
        this.countOfEmployees = countOfEmployees;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
        this.averageSalary = averageSalary;
    }
}