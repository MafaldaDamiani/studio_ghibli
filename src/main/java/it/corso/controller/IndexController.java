package it.corso.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import it.corso.model.Prodotto;
import it.corso.service.ProdottoService;

//localhost:8080
@Controller
@RequestMapping("/")
public class IndexController {
	@Autowired
	ProdottoService prodottoService;
	
	@GetMapping
	public String getPagina(Model model) {
		List<Prodotto> novita = prodottoService.getMerchandisingPerData();
		List<Prodotto> film = prodottoService.getProdottiPerTipologia("Film");
		model.addAttribute("novita", novita.subList(0, 6));
		model.addAttribute("film", film.subList(0, 3));
		return "index";
	}
}
/* @GetMapping("/logout")
public String getLogout(HttpSession session) {
	session.removeAttribute("utente");
	return "redirect:/";
} */
