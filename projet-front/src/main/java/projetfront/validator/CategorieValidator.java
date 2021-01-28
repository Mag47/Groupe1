package projetfront.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import projet.back.entity.Categorie;

public class CategorieValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Categorie.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		
	}

}
