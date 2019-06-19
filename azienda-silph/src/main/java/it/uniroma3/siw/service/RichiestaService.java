package it.uniroma3.siw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import it.uniroma3.siw.model.Richiesta;

import it.uniroma3.siw.repository.RichiestaRepository;


@Service
public class RichiestaService {
	
	@Autowired
	private RichiestaRepository richiestaRepository;
	
	@Transactional 
	public Richiesta inserisci(Richiesta richiesta) {
		return richiestaRepository.save(richiesta);
	}
	
	@Transactional
	public List<Richiesta> tutti(){
		return (List<Richiesta>) richiestaRepository.findAll();
	}

	public Richiesta findById(Long id) {
		
		return richiestaRepository.findById(id).get();
		
	}

}
