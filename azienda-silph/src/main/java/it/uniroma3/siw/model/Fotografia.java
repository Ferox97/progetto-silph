package it.uniroma3.siw.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Fotografia {

    @Id
    private String id;
    
    private String nome;
    
    private String descrizione;

    @ManyToOne
    private Album album;

    @ManyToOne
    private Fotografo fotografo;
    
    
    public Fotografia() {
	}


	public Fotografia(String id, String nome, String descrizione , Album album , Fotografo fotografo) {
		super();
		this.id = id;
		this.nome = nome;
		this.descrizione = descrizione;
		this.album=album;
		this.fotografo=fotografo;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getDescrizione() {
		return descrizione;
	}


	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}


	public Album getAlbum() {
		return album;
	}


	public void setAlbum(Album album) {
		this.album = album;
	}


	public Fotografo getFotografo() {
		return fotografo;
	}


	public void setFotografo(Fotografo fotografo) {
		this.fotografo = fotografo;
	}

    
    }

