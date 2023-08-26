package skypro.dokerandtestcont.repository;

import skypro.dokerandtestcont.pojo.ReportWithPath;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReportWithPathRepository extends CrudRepository<ReportWithPath, Integer> {

    List<ReportWithPath> findAll();

    @Override
    Optional<ReportWithPath> findById(Integer integer);
}
