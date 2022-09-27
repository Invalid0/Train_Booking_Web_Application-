package newTrain.dao;

import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import newTrain.model.DailyReportModel;

@Repository
public interface Unknown extends CrudRepository<DailyReportDAO, Integer>{

	@Query("SELECT d FROM DailyReportDAO d")
	List<DailyReportModel> findAllDailyReport();
}
