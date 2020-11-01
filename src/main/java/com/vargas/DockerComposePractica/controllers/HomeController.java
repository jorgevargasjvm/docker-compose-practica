package com.vargas.DockerComposePractica.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.vargas.DockerComposePractica.models.Poll;

@Controller
public class HomeController {

	
	@PostMapping(value = "/poll/create")
	public String login(Model model, @ModelAttribute Poll poll) {
		
		model.addAttribute("created", true);
		return "home";
	}
	
}
