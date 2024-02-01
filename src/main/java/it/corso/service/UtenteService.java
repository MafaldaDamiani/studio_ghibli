package it.corso.service;

import java.util.List;

import it.corso.model.Utente;

public interface UtenteService {
	
	void registraUtente(); 
	Utente getUtenteById(int id); 
	List<Utente> getUtenti(); 
	void cancellaUtente(Utente utente); 

}
