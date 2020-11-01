package com.vargas.DockerComposePractica.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WelcomeController {

	@GetMapping(value = "/")
	public String index() {
		return "welcome";
	}
	
	@GetMapping(value = "/home")
	public String home() {
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
