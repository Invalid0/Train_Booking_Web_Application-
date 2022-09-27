package newTrain.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import newTrain.model.DailyReportModel;
import newTrain.model.JourneyModel;
import newTrain.model.TrainModel;
import newTrain.service.DailyReportService;
import newTrain.service.JourneyService;
import newTrain.service.TrainService;


@Controller
public class JourneyController {
	
	JourneyService journeyService;
	TrainService trainService;
	DailyReportService dailyReportService;
	DailyReportModel dailyReportModel = new DailyReportModel();
	JourneyModel journeyModel = new JourneyModel();
	@Autowired
	public JourneyController(JourneyService journey, TrainService train,DailyReportService reportService) {
		this.journeyService = journey;
		this.trainService = train;
		this.dailyReportService = reportService;
	}
	
	
	
	@RequestMapping("/journeyBookingPage")
	public String journeyBooking(Model model) {
		int max = 10000000;
		int min = 800000;
		List<newTrain.model.TrainModel> gettraindet = this.trainService.getTrain();
		int journeyBookingId = (int) (Math.random()*(max-min+1)+min);
		model.addAttribute("journeyBookingId", journeyBookingId);
		model.addAttribute("gettraindet", gettraindet);
		System.out.println("Train Model");
		System.out.println(gettraindet);
		return "journeyBookingPage";
		
	}
	
	@RequestMapping(path = "/journeyPage", method = RequestMethod.POST)
	public String journeybBooking(@ModelAttribute JourneyModel journeyModel, @ModelAttribute DailyReportModel dailyReportModel) {
		this.journeyService.createJourney(journeyModel);
//		JourneyModel journeyModel2 = this.dailyReportModel.getJourneyID();
//		System.out.println("Getting the journey id = "+journeyModel2);
//		this.dailyReportModel.setJourneyID(journeyModel2);
//		JourneyModel journeyModel2 = new JourneyModel();
		int x = journeyModel.getJourneyID();
		System.out.println(x);
		TrainModel trainModel = new TrainModel();
		dailyReportModel.setJourneyID(journeyModel);
		dailyReportService.createDailyReport(dailyReportModel);
		
//		this.dailyReportModel.setJourneyModel(journeyModel);
		
		System.out.println(journeyModel);
		
		System.out.println(dailyReportModel);
		System.out.println(journeyModel);
		return"index";
		
	}
	
//	JourneyModel journeyModel2 = this.dailyReportModel.getJourneyModel();
//	System.out.println(journeyModel2);
//	this.dailyReportModel.setJourneyModel(journeyModel2);
//	
	
//	@RequestMapping(path = "/journeyPage", method = RequestMethod.POST)
//	public String journeybBooking(@ModelAttribute JourneyModel journeyModel) {
//		this.journeyService.createJourney(journeyModel);
//		System.out.println(journeyModel);
//		return"index";
//		
//	}
//	
//	
//	@RequestMapping(path = "/journeyPage", method = RequestMethod.POST)
//	public String dialyReportBooking( @ModelAttribute DailyReportModel dailyReportModel) {
//		this.dailyReportService.createDailyReport(dailyReportModel);
//		System.out.println(dailyReportModel);
//		return"index";
//		
//	}
	
}
