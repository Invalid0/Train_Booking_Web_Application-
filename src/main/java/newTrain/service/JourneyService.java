package newTrain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import newTrain.dao.JourneyDAO;
import newTrain.model.JourneyModel;
import newTrain.model.TrainModel;

@Service
public class JourneyService {

	@Autowired
	private JourneyDAO journeyDAO;

	public int createJourney(JourneyModel journeyModel) {
		int id = this.journeyDAO.saveJourney(journeyModel);
		return id;
	}
	
//	get List Data From JourneyDAO class
	public List<JourneyModel> getJourneyModels(){
		System.out.println("In Journey Service ");
		return this.journeyDAO.getJourneyList();
	}

}
