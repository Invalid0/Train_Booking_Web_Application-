package newTrain.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import newTrain.model.JourneyModel;

@Repository
public class JourneyDAO {

	@Autowired
	HibernateTemplate hibernateTemplate;

	@Transactional
	public int saveJourney(JourneyModel journeyModel) {
		int id = (Integer) this.hibernateTemplate.save(journeyModel);
		return id;
	}
	
	//Get List data from Journey
	public List<JourneyModel> getJourneyList() {
		List<JourneyModel> journeyModels = this.hibernateTemplate.loadAll(JourneyModel.class);
		return journeyModels;
	}
	
}
