package it.uniroma3.siw.model;

import org.springframework.web.multipart.MultipartFile;

public class FotografiaForm {
	
	private String nome;
	private String descrizione;
	private Long album_id;
	private String fotografo_id;
	private MultipartFile file;
	
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
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public Long getAlbum_id() {
		return album_id;
	}
	public void setAlbum_id(Long album_id) {
		this.album_id = album_id;
	}
	public String getFotografo_id() {
		return fotografo_id;
	}
	public void setFotografo_id(String fotografo_id) {
		this.fotografo_id = fotografo_id;
	}
	
	
	

}
