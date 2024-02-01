package it.corso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.corso.dao.OrdineDao;
import it.corso.model.Ordine;

@Service
public class OrdineServiceImpl implements OrdineService {

	
	@Autowired
	private OrdineDao ordineDao;
	
	@Override
	public void aggiungiOrdine() {

	}

	@Override
	public List<Ordine> getOrdini() {
		return (List<Ordine>) ordineDao.findAll();
	}

	@Override
	public Ordine getOrdineById(int id) {
		return ordineDao.findById(id).get();
	}

}
