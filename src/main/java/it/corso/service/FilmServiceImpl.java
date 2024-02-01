package it.corso.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.corso.dao.FilmDao;
import it.corso.model.Film;

@Service
public class FilmServiceImpl implements FilmService {
	
	@Autowired
	private FilmDao filmDao; 

	@Override
	public Film getFilmById(int id) {
		
		return filmDao.findById(id).get();
	}

	@Override
	public List<Film> getFilm() {
		
		return (List<Film>) filmDao.findAll();
	}

}
