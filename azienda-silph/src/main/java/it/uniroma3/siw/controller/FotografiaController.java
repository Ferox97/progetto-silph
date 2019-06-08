package it.uniroma3.siw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FotografiaController {

	
	@RequestMapping("/addFotografia")
	public String addStudente(Model model) {
		//model.addAttribute("fotografia", new Fotografia());
		return "fotografiaForm.html";
	}
}
