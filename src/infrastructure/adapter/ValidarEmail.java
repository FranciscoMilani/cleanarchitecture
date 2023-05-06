package infrastructure.adapter;

import org.apache.commons.validator.routines.EmailValidator;

import application.port.IValidadorEmail;

public class ValidarEmail implements IValidadorEmail {

	@Override
	public Boolean validar(String email) {
		EmailValidator validador = EmailValidator.getInstance();
		return validador.isValid(email);
	}

}
