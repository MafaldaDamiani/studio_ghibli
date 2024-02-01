package it.corso.service;

import java.util.List;

import it.corso.model.Ordine;


public interface OrdineService {
	void aggiungiOrdine();
	List<Ordine> getOrdini();
	Ordine getOrdineById(int id); 
}
