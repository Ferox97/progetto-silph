package it.uniroma3.siw.model;

import org.springframework.web.multipart.MultipartFile;


public class FotografiaForm {
    
    private MultipartFile file;
    
	private String nome;
    
    private String descrizione;


    
    public FotografiaForm() {}
    
    

	public FotografiaForm(MultipartFile file, String nome, String descrizione) {
		super();
		this.file = file;
		this.nome = nome;
		this.descrizione = descrizione;
	}

	
    
    public MultipartFile getFile() {
		return file;
	}


	public void setFile(MultipartFile file) {
		this.file = file;
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

    
    }

