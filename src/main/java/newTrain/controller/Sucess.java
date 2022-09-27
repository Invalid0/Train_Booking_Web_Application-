package newTrain.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import newTrain.dao.Unknown;

@Controller
public class Sucess {

	@RequestMapping("/newPage")
	public String newPage(Unknown unknown) {
		System.out.println("In New Page "+unknown.findAll());
		return "newPage";
	}
	
	
}
