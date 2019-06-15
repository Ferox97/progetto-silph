package it.uniroma3.siw.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import it.uniroma3.siw.model.Fotografo;
import it.uniroma3.siw.service.FotografoService;

@Controller
public class FotografoController {
	
	@Autowired
	private FotografoService fotografoService;

	@RequestMapping("/aggiungiFotografo")
	public String addFotografo(Model model) {
		model.addAttribute("fotografo" , new Fotografo());
		return "aggiungiFotografo.html";
	}
	
	@RequestMapping(value = "/showFotografi")
	public String showFotografi(Model model) {
		model.addAttribute("fotografi", this.fotografoService.tutti());
		return "fotografi.html";
	}
	
	@RequestMapping(value="/addFotografo", method = RequestMethod.POST)
    public String newFotografo(@Valid @ModelAttribute("fotografo") Fotografo fotografo, Model model, BindingResult bindingResult) {
    	
        this.fotografoService.inserisci(fotografo); //esegui il persistence
 
      return "aggiungiFotografo.html";
      
    }


}
