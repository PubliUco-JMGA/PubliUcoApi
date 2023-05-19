package co.edu.uco.publiuco.api.validator.persona.common;

import co.edu.uco.publiuco.api.validator.Result;
import co.edu.uco.publiuco.api.validator.Validation;
import co.edu.uco.publiuco.utils.UtilText;

public class PrimerApellidoValidation implements Validation<String>{
	private static final int MINIMUN_LENGHT = 1;
	private static final int MAXIMUN_LENGHT = 30;
	private PrimerApellidoValidation() {
		super();
	}
	public static final Result validate(final String data) {
		return new PrimerApellidoValidation().execute(data);
	}
	@Override
	public Result execute(String data) {
		var result = Result.create();
		
		if(UtilText.isEmpty(data)) {
			result.addMessage("No es posible continuar con el primer apellido vacío");
			
		}else {
			
			if(!UtilText.getUtilText().textHasLenghtAllowed(data, MINIMUN_LENGHT, MAXIMUN_LENGHT)) { 
				result.addMessage("El primer apellido no puede ser menor a 1 o mayor a 30 caracteres");
			}
			if(!UtilText.getUtilText().textHasOnlyLetters(data)) { 
				result.addMessage("El primer apellido solo puede tener letras y espacios");
			}
			
		}
		return result;
	}

}
