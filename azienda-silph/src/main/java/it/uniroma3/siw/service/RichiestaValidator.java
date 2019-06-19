package it.uniroma3.siw.service;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import it.uniroma3.siw.model.Richiesta;

@Component
public class RichiestaValidator implements Validator {
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Richiesta.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mail", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dettaglioRichiesta", "required");

   
	       
	}

}
