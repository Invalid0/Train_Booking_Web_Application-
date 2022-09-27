package newTrain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.javafaker.Faker;

import newTrain.model.JourneyModel;
import newTrain.model.TrainModel;
import newTrain.service.JourneyService;
import newTrain.service.TrainService;

@Controller
public class TrainController {
	
	@Autowired
	private TrainService trainService;
	
	JourneyModel journeyModel = new JourneyModel();
	
	@RequestMapping("/trainBookingPage")
	public String trainBookingPage(Model model) {
		int min = 50000;
		int max = 70000;
		
		Faker city = new Faker();
		String streetAddress = city.address().cityName();
		String address = city.address().cityName();
		
		int trainIdBokking = (int)(Math.random()*(max-min+1)+min);
		model.addAttribute("trainIdBokking",trainIdBokking);
		model.addAttribute("streetAddress",streetAddress);
		model.addAttribute("address",address);
		System.out.println("Query getting" + this.trainService.trainModels());
		return"trainBookingPage";
	}
	
	@RequestMapping(path =  "/trainbookingform", method = RequestMethod.POST)
	public String trainBooking(@ModelAttribute TrainModel trainModel) {
		this.trainService.createTrain(trainModel);
		System.out.println(trainModel);
		return "trainBookingPage";
		
	}
	
}
