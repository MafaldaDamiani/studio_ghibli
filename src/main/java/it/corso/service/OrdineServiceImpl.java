package it.corso.service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.corso.dao.OrdineDao;
import it.corso.dao.ProdottoDao;
import it.corso.model.Ordine;
import it.corso.model.Prodotto;
import it.corso.model.Utente;
import jakarta.servlet.http.HttpSession;

@Service
public class OrdineServiceImpl implements OrdineService {

	@Autowired
	public ProdottoDao prodottoDao;
	
	@Autowired
	private OrdineDao ordineDao;

	
	@Override
	public void aggiungiOrdine(HttpSession session) {
		Ordine ordine = new Ordine();
		@SuppressWarnings("unchecked")
		List<Prodotto> carrello= session.getAttribute("carrello")==null ? new ArrayList<Prodotto>() : (List<Prodotto>) session.getAttribute("carrello");
		ordine.setDataOra(LocalDateTime.now());
		
		ordine.setUtente((Utente)session.getAttribute("utente"));
		
		ordine.setQuantita(1);
		
		ordine.setProdotti(carrello);
		
		double importo = ordine.getProdotti()
				.stream() //ciclo for
				.mapToDouble(Prodotto::getPrezzo)
				.reduce(0.0, (p1,p2) -> p1 + p2);
		ordine.setImporto(importo);
		
		ordineDao.save(ordine);
		carrello.clear();
		session.setAttribute("carrello", carrello); 
	}

	@Override
	public List<Ordine> getOrdini() {
		return (List<Ordine>) ordineDao.findAll();
	}

	@Override
	public Ordine getOrdineById(int id) {
		return ordineDao.findById(id).get();
	}
	
	//Recupero lista di ordini per l'utente
	public List<Ordine> getOrdiniByUser(Utente utente) {
		//Recupero tutti gli ordini a DB
		List<Ordine> list = (List<Ordine>) ordineDao.findAll();
		
		//Filtro gli ordini appartenenti all'utente
		List<Ordine> ordiniUtente = new ArrayList<>();
		for (Ordine ordine : list) {
			if(ordine.getUtente().getId() == utente.getId()) {
				ordiniUtente.add(ordine);
			}
		}
		Comparator<Ordine> byDate = Comparator.comparing(Ordine::getDataOra).reversed();
		ordiniUtente = ordiniUtente
				.stream()
				.sorted(byDate)
				.collect(Collectors.toList());
		//Restituisco la lista con gli ordini filtrati
		return ordiniUtente;
	}

	@Override
	public String diminuisciQuantita(List<Prodotto> carrello) {
		int contatore=0;
		String messaggio;
		for(Prodotto prodotto: carrello) {
			if(prodotto.getQuantitaDisponibile()>0) {
				++ contatore;
			}
		}
		if (contatore==carrello.size()) {
			for(Prodotto prodotto: carrello) {
				prodotto.setQuantitaDisponibile(prodotto.getQuantitaDisponibile()-1);
				prodottoDao.save(prodotto);
			}
			messaggio="Ottimo";
		}else {
			messaggio= "Merda";
		}
		return messaggio;
	}


	/*
	 * getOrdiniByUtente
	 * 1. Recuperi ordini con ordiniDao by utente
	 * 2. Return List<Ordine>
	 */
}