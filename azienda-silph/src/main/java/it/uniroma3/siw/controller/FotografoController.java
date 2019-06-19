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


import it.uniroma3.siw.model.Fotografo;
import it.uniroma3.siw.service.FotografoService;
import it.uniroma3.siw.service.FotografoValidator;

@Controller
public class FotografoController {
	
	@Autowired
	private FotografoService fotografoService;

	@RequestMapping("/aggiungiFotografo")
	public String addFotografo(Model model) {
		model.addAttribute("fotografo" , new Fotografo());
		return "aggiungiFotografo.html";
	}
	
	@RequestMapping(value = "/allFotografi")
	public String showFotografi(Model model) {
		model.addAttribute("fotografi", this.fotografoService.tutti());
		return "fotografi.html";
	}
	
	@Autowired
	FotografoValidator fotografoValidator;
	
	@RequestMapping(value="/addFotografo", method = RequestMethod.POST)
    public String newFotografo(@Valid @ModelAttribute("fotografo") Fotografo fotografo, Model model, BindingResult bindingResult) {
    	
		fotografoValidator.validate(fotografo , bindingResult);
		
		if(bindingResult.hasErrors()) {
			
			return "aggiungiFotografo";
			
		} else {
								
        this.fotografoService.inserisci(fotografo); //esegui il persistence
 
        model.addAttribute("fotografi", this.fotografoService.tutti());
		return "fotografi.html";
		}
    }
	
	@GetMapping(value="/fotografo/{id}")
	public String mostraStudente(@PathVariable("id") Long id , Model model) {
		
		model.addAttribute("fotografie" , fotografoService.getFotoByFotografo(id));
		model.addAttribute("nome" , fotografoService.findById(id).getNome());
		model.addAttribute("cognome" , fotografoService.findById(id).getCognome());
		
		return "fotografieFotografo.html";
		
	}


}
