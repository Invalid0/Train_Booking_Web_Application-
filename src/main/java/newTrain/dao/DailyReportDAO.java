package newTrain.dao;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import newTrain.model.DailyReportModel;

@Repository
public class DailyReportDAO  {

	@Autowired
	HibernateTemplate hibernateTemplate;
	

	@Transactional
	public int saveDailyReport(DailyReportModel dailyReportModel) {
		int id = (Integer) this.hibernateTemplate.save(dailyReportModel);
		System.out.println("In DailyReportDAO Class");
		return id;
	}
	
	

	
//	public List<DailyReportModel> findAllDailyReport();
	
}
