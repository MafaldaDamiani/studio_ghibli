package it.corso.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.corso.dao.ProdottoDao;
import it.corso.model.Prodotto;

@Service
public class ProdottoServiceImpl implements ProdottoService{
	
	@Autowired
	private ProdottoDao prodottoDao;

	@Override
	public Prodotto getProdottoById(int id) {
		
		return prodottoDao.findById(id).get();
	}
	@Override
	public List<Prodotto> getProdotti() {
		
		return (List<Prodotto>) prodottoDao.findAll();
	} 
	@Override
	public List<Prodotto> getProdottiPerTipologia(String tipologiaProdotto) {
		return prodottoDao.getProdottiPerTipologia(tipologiaProdotto);
	}
	@Override
	public List<Prodotto> getProdottiPerCategoria(String categoriaProdotto) {
		return prodottoDao.getProdottiPerCategoria(categoriaProdotto);
	} 
	@Override
	public List<Prodotto> getMerchandisingPerFilm(int filmProdotto) {
		return prodottoDao.getProdottiPerFilm(filmProdotto);
	}
	@Override
	public List<Prodotto> getProdottiPerPrezzoCrescente(String tipologiaProdotto) {
		return prodottoDao.getProdottiPerPrezzoCrescente(tipologiaProdotto);
	}
	@Override
	public List<Prodotto> getProdottiPerPrezzoDecrescente(String tipologiaProdotto) {
		return prodottoDao.getProdottiPerPrezzoDecrescente(tipologiaProdotto);
	}
	@Override
	public List<Prodotto> getFilmPerRating(String ratingFilm) {
		return prodottoDao.getProdottiPerRating(ratingFilm);
	}
	@Override
	public List<Prodotto> getFilmPerGenere(String genereFilm) {
		return prodottoDao.getProdottiPerGenere(genereFilm);
	}
	@Override
	public List<Prodotto> getFilmPerNoleggio(String noleggioFilm) {
		return prodottoDao.getProdottiPerNoleggio(noleggioFilm);
	}
}
