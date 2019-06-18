package it.uniroma3.siw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import it.uniroma3.siw.model.Fotografia;
import it.uniroma3.siw.model.FotografiaForm;
import it.uniroma3.siw.payload.UploadFileResponse;
import it.uniroma3.siw.service.AlbumService;
import it.uniroma3.siw.service.FileStorageService;
import it.uniroma3.siw.service.FotografiaService;
import it.uniroma3.siw.service.FotografoService;
import it.uniroma3.siw.service.FotografiaFormValidator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;



@Controller
public class FotografiaController {

	
	@RequestMapping("/aggiungiFotografia")
	public String addFotografia(Model model) {
		model.addAttribute("fotografiaForm" , new FotografiaForm());
		return "aggiungiFoto.html";
	}
	
	@GetMapping(value = "/allFotografie")
	public String showFotografie(Model model) {
		model.addAttribute("fotografie", this.fotografiaService.tutti());
		return "fotografie.html";
	}
	

	
	//private static final Logger logger = LoggerFactory.getLogger(FotografiaController.class); //Qua era File.Controller

    @Autowired
    private FileStorageService fileStorageService;
    
    @Autowired
    private FotografiaService fotografiaService;
    
    @Autowired 
    private FotografiaFormValidator fotografiaFormValidator;
    
    @Autowired
    private AlbumService albumService;
    
    @Autowired
    private FotografoService fotografoService;
    
    @RequestMapping(value="/uploadFoto", method = RequestMethod.POST)
    public String newFoto(@Valid @ModelAttribute("fotografiaForm") FotografiaForm fotografiaForm, Model model, BindingResult bindingResult)  {
    	
    	fotografiaFormValidator.validate(fotografiaForm , bindingResult);
    	
    	if(bindingResult.hasErrors()) 
    		
    		return "aggiungiFoto.html";
    	
    	else {
    	
    	String fileName = fileStorageService.storeFile(fotografiaForm.getFile());
    	
    	Fotografia fotografia = new Fotografia(fileName , fotografiaForm.getNome() , fotografiaForm.getDescrizione() , 
    			albumService.findById(fotografiaForm.getAlbum_id()) , fotografoService.findById(fotografiaForm.getFotografo_id()));

        this.fotografiaService.inserisci(fotografia); //esegui il persistence
        
        model.addAttribute("fotografie", this.fotografiaService.tutti());
      return "fotografie.html";
      
    	}	
    }
	
}
