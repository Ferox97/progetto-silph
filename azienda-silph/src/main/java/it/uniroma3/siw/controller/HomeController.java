package it.uniroma3.siw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import it.uniroma3.siw.model.Funzionario;

@Controller
public class HomeController {
	
	
	@RequestMapping("/")
	public String addFunzionario(Model model) {
		model.addAttribute("funzionario" , new Funzionario());
		return "index.html";
	}

}
