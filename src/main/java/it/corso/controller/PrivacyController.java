package it.corso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// localhost:8080/privacy
@Controller
@RequestMapping("/privacy")
public class PrivacyController {

	@GetMapping 
	public String getPagina() {
		return "privacy";
	}
}
