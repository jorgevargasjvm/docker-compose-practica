package com.vargas.DockerComposePractica.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.vargas.DockerComposePractica.models.Poll;
import com.vargas.DockerComposePractica.services.PollService;

@Controller
public class HomeController {
	
	@Autowired
	private PollService pollService;

	@PostMapping(value = "/poll/create")
	public String login(Model model, @ModelAttribute Poll poll) {
		if (pollService.savePoll(poll)) {
			model.addAttribute("created", true);
		} else {
			model.addAttribute("created", false);
		}
		
		return "home";
	}
	
}
