package it.uniroma3.siw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import it.uniroma3.siw.model.Fotografia;
import it.uniroma3.siw.payload.UploadFileResponse;
import it.uniroma3.siw.service.FileStorageService;
import it.uniroma3.siw.service.FotografiaService;

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

	
	@RequestMapping("/addFotografia")
	public String addFotografia(Model model) {
		model.addAttribute("fotografia" , new Fotografia());
		return "fotografiaForm.html";
	}
	
	@RequestMapping(value = "/showFotografie")
	public String showFotografie(Model model) {
		model.addAttribute("fotografie", this.fotografiaService.tutti());
		return "fotografie.html";
	}
	
	private static final Logger logger = LoggerFactory.getLogger(FotografiaController.class); //Qua era File.Controller

    @Autowired
    private FileStorageService fileStorageService;
    
    @Autowired
    private FotografiaService fotografiaService;
    
//    @PostMapping("/uploadFile")
//    @ResponseBody
//    //public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file) {
//    public UploadFileResponse uploadFile(@ModelAttribute FotografiaForm fotografia) {
//    	
//    	
//    	
//        String fileName = fileStorageService.storeFile(fotografia.getFile());
//        
//        fotografiaService.inserisci(new Fotografia( fotografia.getFile().getOriginalFilename() , fotografia.getNome() , fotografia.getDescrizione()));
//
//        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
//                .path("/downloadFile/")
//                .path(fileName)
//                .toUriString();
//
//        return new UploadFileResponse(fileName, fileDownloadUri,
//        		fotografia.getFile().getContentType(), fotografia.getFile().getSize());
//    }
    
    @RequestMapping(value="/uploadFoto", method = RequestMethod.POST)
    public String newFoto(@Valid @ModelAttribute("fotografia") Fotografia fotografia, Model model, BindingResult bindingResult, 
        @RequestParam("file") MultipartFile file) {
    	
    	String fileName = fileStorageService.storeFile(file);
    	
    	fotografia.setId(fileName);

        this.fotografiaService.inserisci(fotografia); //esegui il persistence
 
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileName)
                .toUriString();
        
      return "ciao.html";
    		  //new UploadFileResponse(fileName, fileDownloadUri, file.getContentType(), file.getSize());
    }

    @GetMapping("/downloadFile/{fileName:.+}")
    @ResponseBody
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
        // Load file as Resource
        Resource resource = fileStorageService.loadFileAsResource(fileName);

        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            logger.info("Could not determine file type.");
        }

        // Fallback to the default content type if type could not be determined
        if(contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
	
}
