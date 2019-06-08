package it.uniroma3.siw.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Fotografia {

	
	@Id
	private String id;
	
	
	public Fotografia () {}
	
	
	public Fotografia(String id) {
		super();
		this.id = id;
	}

	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}



}
