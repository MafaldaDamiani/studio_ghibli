package it.corso.dao;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import it.corso.model.Prodotto;

public interface ProdottoDao extends CrudRepository<Prodotto, Integer> {
	@Query(value = "SELECT * FROM prodotti WHERE tipologia_prodotto =:t", nativeQuery = true)
	List<Prodotto> getProdottiPerTipologia(@Param("t") String tipologiaProdotto);
	@Query(value = "SELECT * FROM prodotti WHERE categoria =:c", nativeQuery = true)
	List<Prodotto> getProdottiPerCategoria(@Param("c") String categoriaProdotto);
	@Query(value = "SELECT * FROM prodotti WHERE fk_id_film =:f", nativeQuery = true)
	List<Prodotto> getTuttiProdottiPerFilm(@Param("f") int filmProdotto);	
	@Query(value = "SELECT * FROM prodotti WHERE fk_id_film =:f AND tipologia_prodotto != 'Film'", nativeQuery = true)
	List<Prodotto> getProdottiPerFilm(@Param("f") int filmProdotto);
	@Query(value = "SELECT * FROM prodotti WHERE tipologia_prodotto =:t ORDER BY prezzo ASC", nativeQuery = true)
	List<Prodotto> getProdottiPerPrezzoCrescente(@Param("t") String tipologiaProdotto);
	@Query(value = "SELECT * FROM prodotti WHERE tipologia_prodotto =:t ORDER BY prezzo DESC", nativeQuery = true)
	List<Prodotto> getProdottiPerPrezzoDecrescente(@Param("t") String tipologiaProdotto);
	// Join tra Entità.
	// La clausola JOIN p.film f indica una join tra l'entità Prodotto(p)e la relazione film di Prodotto(f).
	// Questo permette di accedere ai campi dell'entità Film all'interno della Query.
	// Non si tratta di una Native Query, in quanto quest'ultima è una query SQL standard che può essere eseguita utilizzando il linguaggio SQL puro, non JPQL.
	// La query qui sotto è scritta in JPQL (Java Persistence Query Language), che è uno specifico linguaggio di query utilizzato con le tecnologie di persistenza Java, come JPA (Java Persistence API).
	@Query("SELECT p FROM Prodotto p JOIN p.film f WHERE f.rating =:r AND p.tipologiaProdotto = 'Film'")
	List<Prodotto> getProdottiPerRating(@Param("r") String ratingFilm);
	@Query("SELECT p FROM Prodotto p JOIN p.film f WHERE f.genere LIKE %:g% AND p.tipologiaProdotto = 'Film'")
	List<Prodotto> getProdottiPerGenere(@Param("g") String genereFilm);
	@Query("SELECT p FROM Prodotto p JOIN p.film f WHERE f.noleggio =:n AND p.tipologiaProdotto = 'Film'")
	List<Prodotto> getProdottiPerNoleggio(@Param("n") String noleggioFilm);
	// Query personalizzata. 
	// Query JPQL per recuperare un Prodotto con tutte le sue relazioni Film basandoci sull'id e sulla tipologiaProdotto.
	// Utilizzando JOIN FETCH, è possibile eseguire una singola Query che recupera sia l'entità principale che le sue associazioni correlate.
	@Query("SELECT p FROM Prodotto p LEFT JOIN FETCH p.film WHERE p.id = :i AND p.tipologiaProdotto = :t")
	Prodotto getProdottoFilmByIdAndTipologia(@Param("i") int id, @Param("t") String tipologiaProdotto);
}
