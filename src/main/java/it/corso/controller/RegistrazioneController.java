package it.corso.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import it.corso.model.Utente;
import it.corso.service.UtenteService;
import jakarta.validation.Valid;

// localhost:8080/registrazione
@Controller
@RequestMapping("/registrazione")
public class RegistrazioneController
{
	@Autowired
	private UtenteService utenteService;
	
	@GetMapping
	public String getPage(Model model)
	{
		Utente utente = new Utente();
		model.addAttribute("utente", utente);
		return "registrazione";
	}
	
	@PostMapping
	public String formManager(
			@Valid @ModelAttribute("utente") Utente utente,
			BindingResult result)
	{
		if(result.hasErrors())
			return "registrazione";
		
		List<Utente> utenti = utenteService.getUtenti();
		for(Utente user : utenti) {
			if (user.getUsername().equals(utente.getUsername())) {
				result.addError(new FieldError("utente", "username", "Username già utilizzato"));
				return "registrazione";
			}
		}
		
		utenteService.registraUtente(utente);
		return "redirect:/registrazione";
	}
}