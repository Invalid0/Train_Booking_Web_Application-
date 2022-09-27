package newTrain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import newTrain.dao.DailyReportDAO;
import newTrain.model.DailyReportModel;

@Service
public class DailyReportService {

	@Autowired
	private DailyReportDAO dailyReportDAO;
	
//	public int createDailyReport(DailyReportModel dailyReportModel) {
//		int id = this.dailyReportDAO.saveDailyReport(dailyReportModel);
//		return id;
//	}

	public int createDailyReport(DailyReportModel dailyReportModel) {
		int id = this.dailyReportDAO.saveDailyReport(dailyReportModel);
		return id;
		
	}
}
