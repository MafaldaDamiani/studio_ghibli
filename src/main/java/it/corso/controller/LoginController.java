package it.corso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.corso.service.UtenteService;
import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;



//localhost:8080/login
@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private UtenteService utenteService; 
	
	@GetMapping
	public String getPage(@RequestParam(name= "err", required= false) String error,
			Model model) {
		
		model.addAttribute("error", error!=null);
		return "login"; 
		
	}
	
	@PostMapping
	public String formManager(
			@RequestParam("username") String username,
			@RequestParam("password") String password,
			HttpSession session,
			Model model) {
		
		if (!utenteService.controlloLogin(username, password, session)) {		
			 
			return "redirect:/login?err"; 
		}			
		
		return "redirect:/"; 
		
	}
	

}
