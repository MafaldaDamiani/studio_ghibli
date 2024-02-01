package it.corso.service;

import java.util.List;

import it.corso.model.Ordine;


public interface OrdineService {
	void aggiungiOrdine();
	void rimuoviOrdine();
	List<Ordine> getordini();
	Ordine getOrdineById(int id); 
}
