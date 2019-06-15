package it.uniroma3.siw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import it.uniroma3.siw.model.FotografiaForm;

@Component
public class FotografiaFormValidator implements Validator {
	
	@Autowired
	private AlbumService albumService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return FotografiaForm.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		FotografiaForm fotografiaForm = (FotografiaForm) target;
		
		if(fotografiaForm.getFile().isEmpty())
            errors.rejectValue("file", "file_vuoto");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nome", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "descrizione", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "album_id", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fotografo_id", "required");
		
		if(fotografiaForm.getAlbum_id()!=null) {
		
		if(!this.albumService.alreadyExistsById(fotografiaForm.getAlbum_id()))
            errors.rejectValue("album_id", "non_esiste_album");
		}
		
		
	        
	       
	}

}
