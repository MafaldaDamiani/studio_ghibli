package it.corso.model;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name="utente")
public class Utente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int id;
	
	@Pattern(regexp = "[a-zA-Z'.\\s]{2,50}", message= "Caratteri non ammessi nel campo nome!")
	@Column(name="nome")
	private String nome;
	
	@Pattern(regexp = "[a-zA-Z'.\\s]{2,50}", message= "Caratteri non ammessi nel campo cognome!")
	@Column(name="cognome")
	private String cognome;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "Inserire una data valida")
	@Column(name="dataDiNascita")
	private LocalDate dataDiNascita;
	
	@Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,30}$", message="Formato indirizzo email non corretto!")
	@Column(name="email")
	private String email;
	
	@Pattern(regexp = "^[0-9]{9,15}$", message="Numero di telefono non corretto!")
	@Column(name="numeroDiTelefono")
	private String numeroDiTelefono;
	
	@Pattern(regexp = "[a-zA-Z'.\\s]{2,50}", message= "Caratteri non ammessi nel campo città!")
	@Column(name="citta")
	private String citta;
	
	@Pattern(regexp = "[a-zA-Z0-9'.\\s]{5,100}", message= "Caratteri non ammessi nel campo indirizzo!")
	@Column(name="indirizzo")
	private String indirizzo;
	
	@Pattern(regexp = "[A-Z]{2}", message= "Caratteri non ammessi nel campo provincia!")
	@Column(name="provincia")
	private String provincia;
	
	@Pattern(regexp = "[0-9]{5}$", message= "Caratteri non ammessi nel campo cap!")
	@Column(name="cap")
	private String cap;
	
	@Pattern(regexp = "[a-zA-Z0-9._-]{2,15}", message= "Caratteri non ammessi nel campo username!")
	@Column(name="username")
	private String username;
	
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[&.?!_-])[a-zA-Z\\d&.?!_-]{8,15}$", message= "La password non rispetta le seguenti caratteristiche: deve avere almeno 8 caratteri, almeno una lettera maiuscola, una lettera minuscola, un numero e un carattere speciale tra &.?!_-")
	@Column(name="password")
	private String password;
	
	//?=.*
	@OneToMany
	(
		mappedBy = "utente",
		cascade = CascadeType.ALL,
		fetch = FetchType.EAGER,
		orphanRemoval = true
	)
	private List<Ordine> ordini= new ArrayList<>();
	
	
	
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
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public LocalDate getDataDiNascita() {
		return dataDiNascita;
	}
	public void setDataDiNascita(LocalDate dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNumeroDiTelefono() {
		return numeroDiTelefono;
	}
	public void setNumeroDiTelefono(String numeroDiTelefono) {
		this.numeroDiTelefono = numeroDiTelefono;
	}
	public String getCitta() {
		return citta;
	}
	public void setCitta(String citta) {
		this.citta = citta;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getCap() {
		return cap;
	}
	public void setCap(String cap) {
		this.cap = cap;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
