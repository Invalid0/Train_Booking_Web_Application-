package newTrain.dao;

import java.util.List;
import newTrain.model.TrainModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public class TrainDAO {

	@Autowired
	HibernateTemplate hibernateTemplate;
	
	
	@Transactional
	public void saveTrain(TrainModel trainModel) {
		this.hibernateTemplate.saveOrUpdate(trainModel);
		
	}

	// Get List of all train
	public List<TrainModel> getTrainmodel() {
		List<TrainModel> allTrain = this.hibernateTemplate.loadAll(TrainModel.class);
		System.out.println("In TrainDao Class");

		System.out.println();
		System.out.println(allTrain);

		return allTrain;
	}
	
	

	// Delete Train using train id;
	@Transactional
	public void deleteTrain(int trainId) {
		TrainModel trainid = this.hibernateTemplate.load(TrainModel.class, trainId);
		this.hibernateTemplate.delete(trainid);
	}

	// single DAO for update
//	@Transactional
//	public TrainModel updateTrain(int trainId) {
//		System.out.println("In DAO class");
//	 return this.hibernateTemplate.get(TrainModel.class,trainId);
//	
//	}

	@Transactional 
	public TrainModel updateTrain(int trainId) {
		TrainModel obj = new TrainModel();
		obj.getTrainId();
		return this.hibernateTemplate.get(TrainModel.class, trainId);
	}

	// Searching a train
//	public TrainModel searchTrain(int id) {
//		TrainModel trainModel = this.hibernateTemplate.load(TrainModel.class, id);
//	
//		return trainModel;
//	}
//	public TrainModel searchTrain(String name) {
//		return TrainModel;
//	}

}
