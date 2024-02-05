package it.corso.service;

import java.util.List;

import it.corso.model.Ordine;
import it.corso.model.Utente;
import jakarta.servlet.http.HttpSession;


public interface OrdineService {
	void aggiungiOrdine(HttpSession session);
	List<Ordine> getOrdini();
	Ordine getOrdineById(int id);
	List<Ordine> getOrdiniByUser(Utente utente);
}
