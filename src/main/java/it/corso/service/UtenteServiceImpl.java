package it.corso.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.corso.dao.UtenteDao;
import it.corso.model.Utente;
import jakarta.servlet.http.HttpSession;

@Service
public class UtenteServiceImpl implements UtenteService {
	
	@Autowired
	private UtenteDao utenteDao;
	
	@Override
	public void registraUtente(Utente utente) {
		/*List<Utente> utenti= getUtenti(); 
		
		if(utenti != null) {
			for(Utente ute : utenti) {
				if 
			}
		}*/
		
		utenteDao.save(utente);

	}

	@Override
	public Utente getUtenteById(int id) {
		
		return utenteDao.findById(id).get();
	}

	@Override
	public List<Utente> getUtenti() {
		
		return (List<Utente>) utenteDao.findAll();
	}

	@Override
	public void cancellaUtente(Utente utente) {
		utenteDao.delete(utente);

	}

	@Override
	public boolean controlloLogin(String username, String password, HttpSession session) {
		
		List<Utente> utenti= getUtenti(); 
		
		for(Utente utente : utenti) {
			if(username.equals(utente.getUsername()) && password.equals(utente.getPassword())) {
				session.setAttribute("utente", utente);
				return true; 	
				
			}		
		}
		return false;
	}
	
}
