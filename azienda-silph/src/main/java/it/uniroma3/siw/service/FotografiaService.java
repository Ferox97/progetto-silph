package it.uniroma3.siw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.siw.model.Fotografia;
import it.uniroma3.siw.repository.FotografiaRepository;


@Service
public class FotografiaService {

	@Autowired
	private FotografiaRepository fotografiaRepository;
	
	@Transactional 
	public Fotografia inserisci(Fotografia fotografia) {
		return fotografiaRepository.save(fotografia);
	}
	
	@Transactional
	public List<Fotografia> tutti(){
		return (List<Fotografia>) fotografiaRepository.findAll();
	}
	
	
	
}
