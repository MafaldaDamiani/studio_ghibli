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
	Model model) {
		model.addAttribute("tipologia", tipologia);
		try {
			int id = Integer.parseInt(idProdotto);
			Prodotto prodotto = prodottoService.getProdottoFilmPerIdETipologia(id, tipologia);
			model.addAttribute("prodotto", prodotto);
			List<Prodotto> collegati = prodottoService.getProdottiPerFilm(prodotto.getFilm().getId());
			List<Prodotto> collegatiDue = prodottoService.getProdottiPerCategoria(prodotto.getCategoria());
			collegati.addAll(collegatiDue);
			Prodotto elementoCollegato; 
			for (int i=1; i<collegati.size(); i++) {
				elementoCollegato = collegati.get(i);
				if(elementoCollegato.getId() == prodotto.getId()) {
					collegati.remove(elementoCollegato);
					i--;
				}
			}
			model.addAttribute ("catalogo", collegati.subList(0, Math.min(4, collegati.size()-1)));
		} catch (Exception e) {
			return "redirect:/catalogo?tipologia=" + tipologia;
		}
		
		return "dettaglio";
	}
	
}
