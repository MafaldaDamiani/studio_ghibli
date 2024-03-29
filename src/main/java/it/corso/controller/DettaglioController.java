package it.corso.controller;
import java.util.Iterator;
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

//localhost:8080/catalogo
@Controller
@RequestMapping("/dettaglio")
public class DettaglioController {
	@Autowired
	private ProdottoService prodottoService;
	@GetMapping
	public String getPagina (
	@RequestParam("id") String idProdotto,
	@RequestParam("tipologia")String tipologia,
	Model model,
	HttpSession session) {
		model.addAttribute("tipologia", tipologia);
		String utente;
		if (session.getAttribute("utente") == null) {
			utente = "no";
		}
		else {
			utente = "si";
		}
		model.addAttribute("utente", utente);
		// Salvo idProdotto e tipologia all'interno di una session, per poterlo poi utilizzare nel metodo aggiungiCarrello.
		session.setAttribute("idProdotto", idProdotto);
		session.setAttribute("tipologiaProdotto", tipologia);
		try {
			int id = Integer.parseInt(idProdotto);
			Prodotto prodotto = prodottoService.getProdottoFilmPerIdETipologia(id, tipologia);
			model.addAttribute("prodotto", prodotto);
			List<Prodotto> collegati = prodottoService.getProdottiPerFilm(prodotto.getFilm().getId());
			List<Prodotto> collegatiDue = prodottoService.getProdottiPerCategoria(prodotto.getCategoria());
			collegati.addAll(collegatiDue);
			
			// Utilizzando Iterator e il metodo remove dell'iterator, si evitano problemi di concorrenza durante la rimozione degli elementi dalla lista mentre si sta iterando su di essa.
			Iterator<Prodotto> iterator = collegati.iterator();
			while (iterator.hasNext()) {
			    Prodotto elementoCollegato = iterator.next();
			    if (elementoCollegato.getId() == prodotto.getId()) {
			        iterator.remove(); // Rimuovi l'elemento utilizzando il metodo remove dell'iterator
			    }
			}
			model.addAttribute ("catalogo", collegati.subList(0, Math.min(4, collegati.size()-1)));
		} catch (Exception e) {
			return "redirect:/catalogo?tipologia=" + tipologia;
		}
		model.addAttribute("tipologia", tipologia);
		return "dettaglio";
	}
	//localhost:8080/dettaglio/aggiungi?id=1
	@GetMapping ("/aggiungi")
	public String gestioneAggiunta(@RequestParam("id")int id, HttpSession session) {
		
		if (session.getAttribute("utente")== null)
			 return "redirect:/login"; 
		prodottoService.aggiungiACarrello(session, id);
		// Recupero idProdotto e tipologiaProdotto dalla sessione, potrò finalmente utilizzare queste String per ritornare alla pagina che stavo visualizzando.
		String idProdotto = (String)session.getAttribute("idProdotto");
		String tipologiaProdotto = (String)session.getAttribute("tipologiaProdotto");
		return "redirect:/dettaglio?id=" + idProdotto + "&tipologia=" + tipologiaProdotto; 
	}	
}
