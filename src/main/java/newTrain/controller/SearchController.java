package newTrain.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.Service;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.internal.SessionFactoryServiceRegistryBuilderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import newTrain.dao.Unknown;
import newTrain.model.JourneyModel;
import newTrain.model.TrainModel;
import newTrain.service.JourneyService;
import newTrain.service.TrainService;

@Controller
public class SearchController {

	@ModelAttribute
	public void trainSearchHedder(Model model) {
		model.addAttribute("Train_Search", "Train Search");
	}

	@Autowired
	TrainService trainService;

	@Autowired
	JourneyService journeyService;

	@RequestMapping("/")
	public String homepage(Model model) {
//		List<JourneyModel> getJourneyData = this.journeyService.getJourneyModels();
//		model.addAttribute("getJourneyData",getJourneyData);
		List<TrainModel> getTrain = trainService.getTrain();
		System.out.println("Main Search");

//		String s = "BNG";
//		for(TrainModel g : getTrain) {
//			if(g.getTrianName().equals(s)) {
//				System.out.println("Train Name is founded");
//			}
//			else {
//				System.out.println("No Train is Avilable");
//			}
//			System.out.println("In loop"+g.getTrianName());
//		}

		model.addAttribute("getTrain", getTrain);
		model.addAttribute("getTrain1", "getTrain");

		return "index";
	}

	@RequestMapping("/delete/{trainId}")
	public RedirectView deleteTrainId(@PathVariable("trainId") int trainId, HttpServletRequest httpServletRequest) {
		this.trainService.deleteTrainId(trainId);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(httpServletRequest.getContextPath() + "/");
		return redirectView;
	}

//	@RequestMapping("/update/{trainId}")
//	public String updateForm(@PathVariable("trainId")int trainId,Model model) {
//		TrainModel trainModel =  this.trainService.updateTrain(trainId);
//		model.addAttribute("trainmodel",trainModel);
//		return "trainBookingPage";
//	}
	
	
	
//	@RequestMapping("/update/{trainId}")
//	public RedirectView updateTrainId(@PathVariable("trainId") int trainId, HttpServletRequest httpServletRequest,
//			Model model) {
//		String update = "Update Page";
//		TrainModel updatetTrainModel =  this.trainService.updateTrain(trainId);
//		System.out.println(updatetTrainModel);
//		RedirectView redirectView = new RedirectView();
//		model.addAttribute("update", update);
//		System.out.println(trainId);
//		System.out.println("Update Sucessfully Complected");
//		redirectView.setUrl(httpServletRequest.getContextPath() + "/trainBookingPage");
//		System.out.println("Update Sucessfully Complected");
//	return redirectView;
//	}
	
	@RequestMapping("/update/{trainId}")
	public String updateTrain(@PathVariable("trainId" )int trainId, Model model,@ModelAttribute TrainModel trainModel ) {
		String update = "Update Train";
		String trainID = "trainId";
		TrainModel trainModelData =  this.trainService.updateTrain(trainId);
		model.addAttribute("update",update);
		model.addAttribute("trainModelData", trainModelData);
		model.addAttribute("trainID",trainID);
		return "trainBookingPage";
	}
	
	
//	@RequestMapping("/updateTrain/{trainId}")
//	public String updateTrain(@PathVariable("trainId")int trainId) {
//		this.trainService.updateTrain(trainId);
//		return"updateTrain";
//	}

//	@RequestMapping("/update/{trainId}")
//	public String update(@PathVariable("trainId") int trainId,Model model) {
//		TrainModel trainUpdates =  this.trainService.updateTrain(trainId);
//		model.addAttribute("trainUpdates",trainUpdates);
//		return "trainBookingPage";
//	}

//	@RequestMapping("/update/{trainId}")
//	public RedirectView updateTrainId (@PathVariable("trainId")int trainId, HttpServletRequest httpServletRequest) {
//		this.trainService.updateTrain(trainId);
//		RedirectView redirectView = new RedirectView();
//		redirectView.setUrl(httpServletRequest.getContextPath()+"/updateTrain");
//		return redirectView;
//	}

	// Searching Data by clicking button.
//	@RequestMapping("/search")
//	public RedirectView searchTrain(Model model, HttpSession session,@RequestParam("bookingId") String bookingId,HttpServletRequest httpServletRequest ) {
//		System.out.println("Searching name = ");
//		System.out.println(bookingId);
//		RedirectView redirectView = new RedirectView();
//		redirectView.setUrl(httpServletRequest.getContextPath()+"/");
//		return redirectView;
//	}

	@RequestMapping("/search")
	public String searchTrain(Model model, HttpSession session, @RequestParam("bookingId") String bookingId) {


		List<TrainModel> getTrain = trainService.getTrain();
		// get all list from journey Model
		List<JourneyModel> getJourney = journeyService.getJourneyModels();

		List<String> trainsName = new ArrayList<>();
//		LinkedHashMap<String,String> trainsName = new LinkedHashMap<>();
		List<String> JourneyList = new ArrayList<>();

		String trainName = "No Data Found";
		String bookinid = "No Data Found";
		String destination = "No Data Found";
		String source = "No Data Found";

		// logic for searching element Train Models
		for (TrainModel train : getTrain) {
			if (train.getTrianName().equals(bookingId) || train.getSource().equals(bookingId) || train.getDestination().equals(bookingId)) {
				trainName = train.getTrianName();
				destination = train.getDestination();
				source = train.getSource();
				System.out.println(trainName);
				trainsName.add(trainName);
				trainsName.add(source);
				trainsName.add(destination);
				System.out.println(trainsName);
				System.out.println("Element is found");
			} else {
				System.out.println("Elemtnt is not found");
			}
		}

		// logic for Searching element Journey model;


		
		model.addAttribute("trainsName",trainsName);
		System.out.println("Trains Name");
		System.out.println(trainsName);
		System.out.println(bookingId);
		return "index";
	}
	

}
