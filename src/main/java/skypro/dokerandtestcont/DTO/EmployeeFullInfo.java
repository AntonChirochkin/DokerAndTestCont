package skypro.dokerandtestcont.DTO;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class EmployeeFullInfo {
    private String name;
    private int salary;
    private String positionName;

    public EmployeeFullInfo(String name, int salary, String positionName) {
        this.name = name;
        this.salary = salary;
        this.positionName = positionName;
    }
    @Override
    public String toString() {
        return "EmployeeFullInfo{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", positionName='" + positionName + '\'' +
                '}';
    }

}
