package it.corso.service;

import java.util.List;

import it.corso.model.Prodotto;
import jakarta.servlet.http.HttpSession;

public interface ProdottoService {
	Prodotto getProdottoById(int id); 
	List<Prodotto> getProdotti();
	List<Prodotto> getProdottiPerTipologia(String tipologiaProdotto);
	List<Prodotto> getProdottiPerCategoria(String categoriaProdotto);
	List<Prodotto> getProdottiPerFilm(int filmProdotto);
	List<Prodotto> getMerchandisingPerFilm(int filmProdotto);
	List<Prodotto> getProdottiPerPrezzoCrescente(String tipologiaProdotto);
	List<Prodotto> getProdottiPerPrezzoDecrescente(String tipologiaProdotto);
	List<Prodotto> getFilmPerRating(String ratingFilm);
	List<Prodotto> getFilmPerGenere(String genereFilm);
	List<Prodotto> getFilmPerNoleggio (String noleggioFilm);
	Prodotto getProdottoFilmPerIdETipologia(int id, String tipologiaProdotto);
	List<Prodotto> getMerchandisingPerData();
	void aggiungiACarrello(HttpSession session, int id);
	void rimuoviDaCarrello(HttpSession session, int id); 
}
