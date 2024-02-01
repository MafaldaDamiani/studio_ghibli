package it.corso.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ordini")
public class Ordine {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "data_ora")
	private LocalDateTime dataOra;
	
	@Column(name = "importo")
	private double importo;
	
	@Column(name = "quantita")
	private int quantita;
	
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "fk_id_utente", referencedColumnName = "id")
	private Utente utente;
	
	@ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	@JoinTable
	(
			name = "ordini_prodotti",
			joinColumns = @JoinColumn(name = "fk_id_ordine", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "fk_id_prodotto", referencedColumnName = "id")
	)
	private List<Prodotto> prodotti = new ArrayList<>();
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public LocalDateTime getDataOra() {
		return dataOra;
	}
	public void setDataOra(LocalDateTime dataOra) {
		this.dataOra = dataOra;
	}
	public double getImporto() {
		return importo;
	}
	public void setImporto(double importo) {
		this.importo = importo;
	}
	public int getQuantita() {
		return quantita;
	}
	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}
	public Utente getUtente() {
		return utente;
	}
	public void setUtente(Utente utente) {
		this.utente = utente;
	}

}
