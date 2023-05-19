package co.edu.uco.publiuco.api.validator.persona.common;

import co.edu.uco.publiuco.api.validator.Result;
import co.edu.uco.publiuco.api.validator.Validation;
import co.edu.uco.publiuco.utils.UtilText;

public class NumeroTelefonoValidation implements Validation<String>{
	private static final int MINIMUN_LENGHT = 6;
	private static final int MAXIMUN_LENGHT = 15;
	private NumeroTelefonoValidation() {
		super();
	}
	public static final Result validate(final String data) {
		return new NumeroTelefonoValidation().execute(data);
	}
	@Override
	public Result execute(String data) {
		var result = Result.create();
		
		if(UtilText.isEmpty(data)) {
			result.addMessage("No es posible continuar con el número de teléfono vacío");
			
		}else {
			
			if(!UtilText.getUtilText().textHasLenghtAllowed(data, MINIMUN_LENGHT, MAXIMUN_LENGHT)) { 
				result.addMessage("El número de teléfono no puede ser menor a 1 o mayor a 11 caracteres");
			}
			if(!UtilText.getUtilText().numericIsValid(data)) { 
				result.addMessage("El número de teléno solo puede tener números");
			}
			
		}
		return result;
	}

}
