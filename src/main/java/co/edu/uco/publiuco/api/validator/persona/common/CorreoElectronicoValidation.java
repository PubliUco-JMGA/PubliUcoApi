package co.edu.uco.publiuco.api.validator.persona.common;

import co.edu.uco.publiuco.api.validator.Result;
import co.edu.uco.publiuco.api.validator.Validation;
import co.edu.uco.publiuco.utils.UtilText;

public class CorreoElectronicoValidation implements Validation<String>{
	private static final int MINIMUN_LENGHT = 1;
	private static final int MAXIMUN_LENGHT = 50;
	private CorreoElectronicoValidation() {
		super();
	}
	public static final Result validate(final String data) {
		return new CorreoElectronicoValidation().execute(data);
	}
	@Override
	public Result execute(String data) {
		var result = Result.create();
		
		if(UtilText.isEmpty(data)) {
			result.addMessage("No es posible continuar con el correo electrónico vacío");
			
		}else {
			
			if(!UtilText.getUtilText().textHasLenghtAllowed(data, MINIMUN_LENGHT, MAXIMUN_LENGHT)) { 
				result.addMessage("El correo no puede ser menor a 1 o mayor a 50 caracteres");
			}
			if(!UtilText.getUtilText().textHasOnlyLetters(data)) { 
				result.addMessage("El nombre del estado solo puede tener letras y espacios");
			}
			if(!UtilText.getUtilText().emailIsvalid(data)) {
				result.addMessage("El correo no cumple con el formato de correo electrónico");
			}
			
		}
		return result;
	}

}
