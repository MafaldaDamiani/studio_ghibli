package it.corso.model;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="prodotti")
public class Prodotto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="tipologia_prodotto")
	private String tipologiaProdotto;
	
	@Column(name="categoria")
	private String categoria; 
	
	@Column(name="descrizione")
	private String descrizione;
	
	@Column(name="prezzo")
	private double prezzo; 
	
	@Column(name="immagine")
	private String immagine; 
	
	@Column(name="data_inserimento")
	private LocalDate dataInserimento;
	
	@Column(name="quantita_disponibile")
	private int quantitaDisponibile;
	
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name="fk_id_film",referencedColumnName = "id" )
	private Film film; 
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTipologiaProdotto() {
		return tipologiaProdotto;
	}
	public void setTipologiaProdotto(String tipologiaProdotto) {
		this.tipologiaProdotto = tipologiaProdotto;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	public String getImmagine() {
		return immagine;
	}
	public void setImmagine(String immagine) {
		this.immagine = immagine;
	}
	public LocalDate getDataInserimento() {
		return dataInserimento;
	}
	public void setDataInserimento(LocalDate dataInserimento) {
		this.dataInserimento = dataInserimento;
	}
	public int getQuantitaDisponibile() {
		return quantitaDisponibile;
	}
	public void setQuantitaDisponibile(int quantitaDisponibile) {
		this.quantitaDisponibile = quantitaDisponibile;
	} 

}
