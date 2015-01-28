package common.model.repository;

import common.model.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.util.List;

//This is spring data access object
public interface ReportRepository extends JpaRepository<Report, Long> {

//Create a new query to search in the database
    @Query(value = "select r from reports r where r.startDate >= ? and  r.endDate <= ?")
    List<Report> findBetweenSdateAndEdate(Date date1, Date date2);
}
