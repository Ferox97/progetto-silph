package it.uniroma3.siw.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import it.uniroma3.siw.model.Album;
import it.uniroma3.siw.service.AlbumService;
import it.uniroma3.siw.service.AlbumValidator;

@Controller
public class AlbumController {
	
	@Autowired
	private AlbumService albumService;

	@RequestMapping("/aggiungiAlbum")
	public String addAlbum(Model model) {
		model.addAttribute("album" , new Album());
		return "aggiungiAlbum.html";
	}
	
	@RequestMapping(value = "/allAlbum")
	public String showAlbum(Model model) {
		model.addAttribute("albums", this.albumService.tutti());
		return "album.html";
	}
	
	@GetMapping(value="/album/{id}")
	public String mostraStudente(@PathVariable("id") Long id , Model model) {
		
		model.addAttribute("fotografie" , albumService.getFotoByAlbum(id));
		model.addAttribute("nome" , albumService.findById(id).getNome());
		model.addAttribute("descrizione" , albumService.findById(id).getDescrizione());
		
		return "fotografieAlbum.html";
		
	}
	
	@Autowired
	AlbumValidator albumValidator;
	
	@RequestMapping(value="/addAlbum", method = RequestMethod.POST)
    public String newAlbum(@Valid @ModelAttribute("album") Album album, Model model, BindingResult bindingResult) {
    	
		albumValidator.validate(album , bindingResult);
		
		if(bindingResult.hasErrors()) {
			
			return "aggiungiAlbum";
			
		} else {
		
        this.albumService.inserisci(album); //esegui il persistence
 
        model.addAttribute("albums", this.albumService.tutti());
		return "album.html";
		
		}
      
    }


}
