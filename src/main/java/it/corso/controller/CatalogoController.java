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

// localhost:8080/catalogo
@Controller
@RequestMapping("/catalogo")
public class CatalogoController {
	
	@Autowired
	private ProdottoService prodottoService;
	
	@GetMapping 
	public String getPagina(
		@RequestParam("tipologia")String tipologia,
		@RequestParam(name = "filtro", required = false)String filtro,
		@RequestParam(name = "nome", required = false)String tipoFiltro,
		Model model,
		HttpSession session) {
		String utente;
		if (session.getAttribute("utente") == null) {
			utente = "no";
		}
		else {
			utente = "si";
		}
		model.addAttribute("utente", utente);
		model.addAttribute("tipologiaLink", tipologia);
		model.addAttribute("tipologiaTesto", tipologia.toUpperCase());
		List <Prodotto> catalogo = null;
		if (filtro != null) {
			if(filtro.equals("Categoria")) {
				catalogo = prodottoService.getProdottiPerCategoria(tipoFiltro);
			}
			else if (filtro.equals("Film")) {
				int idFilm = 0;
				try {
					idFilm = Integer.parseInt(tipoFiltro);
				} catch (Exception e) {
					return "redirect:/categoria?tipologia=Merchandising";
				}
				catalogo = prodottoService.getMerchandisingPerFilm(idFilm);
			}
			else if(filtro.equals("Ordina")) {
				if (tipoFiltro.equals("Crescente")) {
					catalogo = prodottoService.getProdottiPerPrezzoCrescente(tipologia);
				}
				else {
					catalogo = prodottoService.getProdottiPerPrezzoDecrescente(tipologia);
				}
			}
			else if(filtro.equals("Genere")) {
				catalogo = prodottoService.getFilmPerGenere(tipoFiltro);
			}			
			else if(filtro.equals("Rating")) {
				catalogo = prodottoService.getFilmPerRating(tipoFiltro);
			}
			else if(filtro.equals("Noleggio")) {
				catalogo = prodottoService.getFilmPerNoleggio(tipoFiltro);
			}
		}
		else {
			catalogo = prodottoService.getProdottiPerTipologia(tipologia);
		}
		model.addAttribute("catalogo", catalogo);
		return "catalogo";
	}
	
	//localhost:8080/catalogo/aggiungi?id=1&tipologia=Merchandainsing
	@GetMapping ("/aggiungi")
	public String gestioneAggiunta(@RequestParam("id")int id, HttpSession session, @RequestParam("tipologia") String tipologia) {
		
		if (session.getAttribute("utente")== null)
			 return "redirect:/login"; 
		
		prodottoService.aggiungiACarrello(session, id); 
		return "redirect:/catalogo?tipologia=" + tipologia; 
	}
}
