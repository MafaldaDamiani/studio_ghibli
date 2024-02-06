package it.corso.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import it.corso.model.Ordine;
import it.corso.model.Utente;
import it.corso.service.OrdineService;
import it.corso.service.ProdottoService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/ordine")
public class OrdineController {
	
	@Autowired
	private OrdineService ordineService;	
	
	
	
	//localhost:8080/ordine
	@GetMapping
	public String getPage(Model model, HttpSession session) {
		if (session.getAttribute("utente")== null)
			 return "redirect:/login";
		
		List<Ordine> ordini = ordineService.getOrdiniByUser((Utente) session.getAttribute("utente"));
		model.addAttribute("ordine", ordini);
		return "ordine";
		
	}
	
	
	/*@GetMapping("/aggiungi")
	public String aggiungiOrdine(HttpSession session) {
		ordineService.aggiungiOrdine(session);
		return "redirect:/ordine";
	}*/
	
	/*@GetMapping("/id")
	public String getDettagliOrdine(@RequestParam ("id") String idOrdine, Model model) {
		try {
			int id=Integer.parseInt(idOrdine);
			List<Prodotto> prodottiOrdine= ordineService.getOrdineById(id).getProdotti();
			model.addAttribute("prodottiOrdine", prodottiOrdine);
		}catch(Exception e) {
			return "redirect:/carrello";
		}
		return "ordine";
		
	}*/
}
