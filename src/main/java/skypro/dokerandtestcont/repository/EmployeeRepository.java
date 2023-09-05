package skypro.dokerandtestcont.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import skypro.dokerandtestcont.DTO.EmployeeFullInfo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import skypro.dokerandtestcont.DTO.EmployeeReport;
import skypro.dokerandtestcont.pojo.Employee;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {


    @Query("SELECT  new skypro.dokerandtestcont.DTO.EmployeeFullInfo(e.name, e.salary, p.name) FROM Employee e join e.position p")
    List<EmployeeFullInfo> findAllEmployeeFullInfo();

    @Query("SELECT new skypro.dokerandtestcont.DTO." +
            "EmployeeFullInfo(e.name , e.salary , p.name) " +
            "FROM Employee e join fetch Position p " +
            "WHERE e.position = p AND e.id=?1")
    Optional<EmployeeFullInfo> findByIdFullInfo(Integer id);

    Optional<Employee> findFirstByOrderBySalaryDesc();

    @Query("SELECT new skypro.dokerandtestcont.DTO." +
            "EmployeeFullInfo(e.name , e.salary , p.name) " +
            "FROM Employee e join e.position p WHERE p.id=?1")
    List<EmployeeFullInfo> findEmployeeByPosition(Integer position);


    @Query("SELECT new skypro.dokerandtestcont.DTO." +
            "EmployeeReport(e.department , COUNT(e.name) , MIN(e.salary), max(e.salary), avg(e.salary)) " +
            "FROM Employee e GROUP BY e.department")
    List<EmployeeReport> getReport();

    Optional<Employee> findById (Integer id);

    @Override
    <S extends Employee> S save(S entity);
}
