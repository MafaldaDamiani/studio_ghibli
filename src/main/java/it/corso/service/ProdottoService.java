package it.corso.service;

import java.util.List;

import it.corso.model.Prodotto;

public interface ProdottoService {
	Prodotto getProdottoById(int id); 
	List<Prodotto> getProdotti();
}
