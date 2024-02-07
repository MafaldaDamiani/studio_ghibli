package it.corso.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import it.corso.model.Prodotto;
import it.corso.model.Utente;
import it.corso.service.OrdineService;
import it.corso.service.ProdottoService;
import jakarta.servlet.http.HttpSession;

//localhost:8080/carrello
@Controller
@RequestMapping ("/carrello")
public class CarrelloController {
	
	@Autowired
	public ProdottoService prodottoService;
	
	@Autowired
	public OrdineService ordineService; 
	
	@SuppressWarnings("unchecked")
	@GetMapping
	public String getPage(@RequestParam(name="stop", required=false)String stop,@RequestParam(name="success", required=false)String success, Model model, HttpSession session) {
		
		 if (session.getAttribute("utente")== null)
			 return "redirect:/login"; 
		 
		 List<Prodotto> carrello= (List<Prodotto>) session.getAttribute("carrello");
		 Utente utente= (Utente) session.getAttribute("utente"); 
			model.addAttribute("carrello", carrello);
			model.addAttribute("utente", utente); 
			
			model.addAttribute("stop", stop);
			model.addAttribute("success", success); 
			return "carrello";

	}
			
	
	@GetMapping ("/rimuovi")
	public String gestisciRimozione(@RequestParam("id")int idArticolo, HttpSession session) {
		prodottoService.rimuoviDaCarrello(session, idArticolo);
		return "redirect:/carrello"; 
		}
	
	@SuppressWarnings("unchecked")
	@GetMapping("/aggiungi")
	public String aggiungiOrdine(HttpSession session, Model model) {
		
		List<Prodotto> carrello= (List<Prodotto>) session.getAttribute("carrello"); 
		
		if (carrello.isEmpty()) {
			return "redirect:/carrello?stop";
		}else {
			ordineService.aggiungiOrdine(session);
			return "redirect:/carrello?success";
		}
	}
			

}
