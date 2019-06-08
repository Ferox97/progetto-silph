package it.uniroma3.siw.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.model.Fotografia;


public class FotografiaRepository {

	public interface StudenteRepository extends CrudRepository<Fotografia,Long> {
		//findByDatiDaRecuperare(sarebbero le variabili)
		public List<Fotografia> findByNome(String nome);
		public List<Fotografia> findByNomeAndCognome(String nome, String cognome);
	}
	
}