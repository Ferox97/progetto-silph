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

import it.uniroma3.siw.model.Funzionario;
import it.uniroma3.siw.model.Richiesta;

import it.uniroma3.siw.service.RichiestaService;

@Controller
public class RichiestaController {
	
	@Autowired
	private RichiestaService richiestaService;

	@RequestMapping("/aggiungiRichiesta")
	public String addRichiesta(Model model) {
		model.addAttribute("richiesta" , new Richiesta());
		return "aggiungiRichiesta.html";
	}
	
	@RequestMapping(value = "/allRichieste")
	public String showRichieste(Model model) {
		model.addAttribute("richieste", this.richiestaService.tutti());
		return "richieste.html";
	}
	
	@RequestMapping(value="/addRichiesta", method = RequestMethod.POST)
    public String newRichiesta(@Valid @ModelAttribute("richiesta") Richiesta richiesta, Model model, BindingResult bindingResult) {
    	
        this.richiestaService.inserisci(richiesta); //esegui il persistence
        model.addAttribute("funzionario" , new Funzionario());
 
      return "index.html";
      
    }
	
	@GetMapping(value="/richiesta/{id}")
	public String mostraStudente(@PathVariable("id") Long id , Model model) {
		
		model.addAttribute("mail" , richiestaService.findById(id).getMail());
		model.addAttribute("dettaglioRichiesta" , richiestaService.findById(id).getDettaglioRichiesta());
		
		return "richiesta.html";
		
	}


}
