package com.vargas.DockerComposePractica.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vargas.DockerComposePractica.services.PollService;

@Controller
public class WelcomeController {
	
	@Autowired
	private PollService pollService;

	@GetMapping(value = "/")
	public String index() {
		return "welcome";
	}
	
	@GetMapping(value = "/home")
	public String home(Model model) {
		model.addAttribute("polls", pollService.getPollsList());
		model.addAttribute("chartData", pollService.getBarGraphData());
		return "home";
	}
	
	@GetMapping(value = "/login")
	public String login(Model model, @RequestParam(required = false) Boolean error) {
		if (error != null) {
			model.addAttribute("error", true);
		} else {
			model.addAttribute("error", false);
		}
		return "login";
	}
	
}
