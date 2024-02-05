package it.corso.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.corso.model.Ordine;
import it.corso.model.Utente;
import it.corso.service.OrdineService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/ordine")
public class OrdineController {
	
	@Autowired
	private OrdineService ordineService;
	
	//localhost:8080/ordine?id=1
	//localhost:8080/ordine/1
	@GetMapping
	public String getPage(Model model, HttpSession session) {
		if (session.getAttribute("utente")== null)
			 return "redirect:/login";
		
		List<Ordine> ordini = ordineService.getOrdiniByUser((Utente) session.getAttribute("utente"));
		model.addAttribute("ordine", ordini);
		return "ordine";
		
	}
	
	//localhost:8080/ordine
	@GetMapping("/aggiungi")
	public String aggiungiOrdine(HttpSession session) {
		ordineService.aggiungiOrdine(session);
		return "redirect:/ordine";
	}
	
	/*@GetMapping("/{id}")
	public String getDettagliOrdine(@PathVariable String id) {
		//ordineService.getDettagliOrdine(id)
		return "ordine";
	}*/

}
