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
import javax.persistence.PrimaryKeyJoinColumn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.NonNull;

@Entity
public class JourneyModel {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NonNull
	private int journeyID;
	private int bookingID;
	private int phoneNumber;
	private String agency;

	@OneToOne(mappedBy = "journeyID")
	private DailyReportModel dailyReportModel;
	
	public DailyReportModel getDailyReportModel() {
		return dailyReportModel;
	}
	public void setDailyReportModel(DailyReportModel dailyReportModel) {
		this.dailyReportModel = dailyReportModel;
	}
	
	public int getJourneyID() {
		return journeyID;
	}

	public int getBookingID() {
		return bookingID;
	}

	public void setBookingID(int bookingID) {
		this.bookingID = bookingID;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAgency() {
		return agency;
	}


	public void setAgency(String agency) {
		this.agency = agency;
	}

	@Override
	public String toString() {
		return "JourneyModel [journeyID=" + journeyID + ", bookingID=" + bookingID + ", phoneNumber=" + phoneNumber
				+ ", agency=" + agency +  "trainId="
				+"]";
	}	

}
