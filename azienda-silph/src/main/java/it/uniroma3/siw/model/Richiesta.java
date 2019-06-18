package it.uniroma3.siw.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Richiesta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String mail;
	private String dettaglioRichiesta;
	
	@ManyToMany
	private List<Fotografia> fotografie;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public List<Fotografia> getFotografie() {
		return fotografie;
	}

	public void setFotografie(List<Fotografia> fotografie) {
		this.fotografie = fotografie;
	}

	public String getDettaglioRichiesta() {
		return dettaglioRichiesta;
	}

	public void setDettaglioRichiesta(String dettaglioRichiesta) {
		this.dettaglioRichiesta = dettaglioRichiesta;
	}
}
