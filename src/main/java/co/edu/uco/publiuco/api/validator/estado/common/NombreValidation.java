package co.edu.uco.publiuco.api.validator.estado.common;

import co.edu.uco.publiuco.api.validator.Result;
import co.edu.uco.publiuco.api.validator.Validation;
import co.edu.uco.publiuco.utils.UtilText;

public class NombreValidation implements Validation<String>{
	private static final int MINIMUN_LENGHT = 1;
	private static final int MAXIMUN_LENGHT = 50;
	private NombreValidation() {
		super();
	}
	public static final Result validate(final String data) {
		return new NombreValidation().execute(data);
	}
	@Override
	public Result execute(String data) {
		var result = Result.create();
		
		if(UtilText.isEmpty(data)) {
			result.addMessage("No es posible continuar con el nombre del estado vacío");
			
		}else {
			
			if(!UtilText.getUtilText().textHasLenghtAllowed(data, MINIMUN_LENGHT, MAXIMUN_LENGHT)) { 
				result.addMessage("El nombre del estado no puede ser menor a 1 o menor a 30 caracteres");
			}
			if(!UtilText.getUtilText().textHasOnlyLetters(data)) { 
				result.addMessage("El nombre del estado solo puede tener letras y espacios");
			}
			
		}
		return result;
	}

}
