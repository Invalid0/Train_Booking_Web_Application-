package newTrain.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;



@Entity
public class TrainModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NonNull
	private int trainId;
	private int trainNo;
	private String trianName;
	private String source;
	private String destination;
	

	public int getTrainId() {
		return trainId;
	}

	public void setTrainId(int trainId) {
		this.trainId = trainId;
	}

	
	public String getTrianName() {
		return trianName;
	}

	public void setTrianName(String trianName) {
		this.trianName = trianName;
	}

	public int getTrainNo() {
		return trainNo;
	}


	public void setTrainNo(int trainNo) {
		this.trainNo = trainNo;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	@Override
	public String toString() {
		return "JourneyModel [trainId=" +trainId+  "trainNo=" + trainNo + ", source=" + source + ", destination=" + destination + "]";
	}

}
