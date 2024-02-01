package it.corso.service;
import java.util.List;
import it.corso.model.Film;

public interface FilmService {
	Film getFilmById(int id); 
	List<Film> getFilm(); 

}
