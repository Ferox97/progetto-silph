package it.uniroma3.siw.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Silph {
	
	@Id
	private String nome;
	private String descrizione;
	
	@OneToMany(mappedBy = "azienda")
	private List<Funzionario> funzionari;
	
	@OneToMany
	private List<Richiesta> richieste;
	
	@OneToMany
	private List<Album> album;
	
	@OneToMany
	private List<Fotografo> fotografi;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String desc) {
		this.descrizione = desc;
	}
	public List<Funzionario> getFunzionari() {
		return funzionari;
	}
	public void setFunzionari(List<Funzionario> funzionari) {
		this.funzionari = funzionari;
	}
	public List<Richiesta> getRichieste() {
		return richieste;
	}
	public void setRichieste(List<Richiesta> richieste) {
		this.richieste = richieste;
	}
	public List<Album> getAlbum() {
		return album;
	}
	public void setAlbum(List<Album> album) {
		this.album = album;
	}
	public List<Fotografo> getFotografi() {
		return fotografi;
	}
	public void setFotografi(List<Fotografo> fotografi) {
		this.fotografi = fotografi;
	}

}