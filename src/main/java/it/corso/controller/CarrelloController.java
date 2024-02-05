package it.corso.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.corso.model.Prodotto;
import it.corso.service.ProdottoService;
import jakarta.servlet.http.HttpSession;

//localhost:8080/carrello
@Controller
@RequestMapping ("/carrello")
public class CarrelloController {
	
	@Autowired
	public ProdottoService prodottoService; 
	
	@SuppressWarnings("unchecked")
	@GetMapping
	public String getPage(Model model, HttpSession session) {
		
		 if (session.getAttribute("utente")== null)
			 return "redirect:/login"; 
		 
		 List<Prodotto> carrello= (List<Prodotto>) session.getAttribute("carrello");
			model.addAttribute("carrello", carrello); 
			return "carrello";

	}
			
	
	@GetMapping ("/rimuovi")
	public String gestisciRimozione(@RequestParam("id")int idArticolo, HttpSession session) {
		prodottoService.rimuoviDaCarrello(session, idArticolo);
		return "redirect:/carrello"; 
		}
			

}
