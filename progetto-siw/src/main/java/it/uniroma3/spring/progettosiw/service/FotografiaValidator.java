package it.uniroma3.spring.progettosiw.service;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import it.uniroma3.siw.model.Fotografo;

@Component
public class FotografiaValidator implements Validator{
	
	@Override
	public boolean supports(Class<?> aClass) {
		return Fotografo.class.equals(aClass);

	}

	@Override
	public void validate(Object o, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "titolo", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "prezzo", "required");
	}

}
