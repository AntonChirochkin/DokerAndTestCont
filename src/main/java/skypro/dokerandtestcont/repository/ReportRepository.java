package skypro.dokerandtestcont.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import skypro.dokerandtestcont.pojo.Report;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReportRepository extends CrudRepository<Report, Integer> {

    List<Report> findAll();

    @Override
    Optional<Report> findById(Integer integer);
}