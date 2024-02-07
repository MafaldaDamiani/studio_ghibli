package it.corso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;


//localhost:8080
@Controller
@RequestMapping("/")
public class IndexController {
	
	@GetMapping
	public String getPage() {
		return "index";
	}
	
	@GetMapping("/logout")
	public String getLogout(HttpSession session) {
		session.removeAttribute("utente");
		return "redirect:/";
	}
}
