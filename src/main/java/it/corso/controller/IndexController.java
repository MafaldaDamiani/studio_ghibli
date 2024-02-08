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

//localhost:8080
@Controller
@RequestMapping("/")
public class IndexController {
	@Autowired
	ProdottoService prodottoService;
	
	@GetMapping
	public String getPagina(Model model, HttpSession session) {
		String utente;
		if (session.getAttribute("utente") == null) {
			utente = "no";
		}
		else {
			utente = "si";
		}
		List<Prodotto> novita = prodottoService.getMerchandisingPerData();
		List<Prodotto> film = prodottoService.getProdottiPerTipologia("Film");
		model.addAttribute("utente", utente);
		model.addAttribute("novita", novita.subList(0, 6));
		model.addAttribute("film", film.subList(0, 3));
		return "index";
	}
	//localhost:8080/aggiungi?id=1&tipologia=Merchandainsing
	@GetMapping ("/aggiungi")
	public String gestioneAggiunta(@RequestParam("id")int id, HttpSession session, @RequestParam("tipologia") String tipologia) {
		
		if (session.getAttribute("utente")== null)
			 return "redirect:/login"; 
		
		prodottoService.aggiungiACarrello(session, id); 
		return "redirect:/"; 
	}
	@GetMapping("/logout")
	public String getLogout(HttpSession session) {
		session.removeAttribute("utente");
		return "redirect:/";
	}
}
