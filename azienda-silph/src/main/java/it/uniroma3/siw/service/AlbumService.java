package it.uniroma3.siw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.siw.model.Album;
import it.uniroma3.siw.repository.AlbumRepository;


@Service
public class AlbumService {
	
	@Autowired
	private AlbumRepository albumRepository;
	
	@Transactional 
	public Album inserisci(Album album) {
		return albumRepository.save(album);
	}
	
	@Transactional
	public List<Album> tutti(){
		return (List<Album>) albumRepository.findAll();
	}

	public boolean alreadyExistsById(Long album_id) {

		return albumRepository.existsById(album_id);
	}

}
