package it.uniroma3.siw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.siw.model.Fotografia;
import it.uniroma3.siw.model.Fotografo;
import it.uniroma3.siw.repository.FotografoRepository;


@Service
public class FotografoService {

	@Autowired
	private FotografoRepository fotografoRepository;

	@Transactional 
	public Fotografo inserisci(Fotografo fotografo) {
		return fotografoRepository.save(fotografo);
	}

	@Transactional
	public List<Fotografo> tutti(){
		return (List<Fotografo>) fotografoRepository.findAll();
	}

	@Transactional
	public boolean alreadyExistsById(Long album_id) {

		return fotografoRepository.existsById(album_id);
	}

	public Fotografo findById(Long id) {

		return fotografoRepository.findById(id).get();

	}
	
	@Transactional
	public List<Fotografia> getFotoByFotografo(Long id) {
		return (List<Fotografia>)fotografoRepository.findById(id).get().getFotografie();
	}

}
