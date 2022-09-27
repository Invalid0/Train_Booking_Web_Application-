package newTrain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import newTrain.dao.TrainDAO;
import newTrain.model.TrainModel;


@Service
public class TrainService {

	
	@Autowired
	private TrainDAO trainDAO;
	
	
	public void createTrain(TrainModel trainModel) {
		this.trainDAO.saveTrain(trainModel);
	}
//	public List<TrainModel> getTrainNo(){
//	
//		return this.trainDAO.getTrainmodel();
//	
//	}
	public List<TrainModel> getTrain(){
		System.out.println(this.trainDAO.getTrainmodel());
		return this.trainDAO.getTrainmodel();
	}
	
	//delete train Id
	public void deleteTrainId(int trainId) {
		this.trainDAO.deleteTrain(trainId);
	}
	
	
	//update Train Id
	public TrainModel updateTrain(int trainId) {
		System.out.println("In service Update");
		System.out.println(this.trainDAO.updateTrain(trainId));
		return this.trainDAO.updateTrain(trainId);
	}
	
	//Getting Train Query From TrainModel Class;
	public List<TrainModel> trainModels(){
		return this.trainDAO.getTrainmodel(); 
	}
	
	
}
