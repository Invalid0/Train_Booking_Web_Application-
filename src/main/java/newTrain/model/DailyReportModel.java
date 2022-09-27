package newTrain.model;


import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class DailyReportModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String trianName;
	private String from1;
	private String to1;
	
	//@DateTimeFormat(pattern = "dd/mm/yyyy")
	
	@DateTimeFormat(pattern = "dd/mm/yyyy")
	private Date date1;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "j_id")
	private JourneyModel journeyID;
	
	
	
	
	public Date getDate1() {
		return date1;
	}
	public void setDate1(Date date1) {
		this.date1 = date1;
	}
	
	
	public JourneyModel getJourneyID() {
		return journeyID;
	}
	
	public void setJourneyID(JourneyModel journeyID) {
		this.journeyID = journeyID;
	}
	public String getFrom1() {
		return from1;
	}
	public String getTrianName() {
		return trianName;
	}
	public void setTrianName(String trianName) {
		this.trianName = trianName;
	}
	public void setFrom1(String from1) {
		this.from1 = from1;
	}
	public String getTo1() {
		return to1;
	}
	public void setTo1(String to1) {
		this.to1 = to1;
	}
	@Override
	public String toString() {
		return "DailyReportModel [id=" + id + ", trianName=" + trianName + ", from1=" + from1 + ", to1=" + to1
				+  ", journeyID=" + journeyID + "]";
	}
	
	
	
	
	
}
