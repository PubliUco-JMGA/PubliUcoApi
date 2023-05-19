package co.edu.uco.publiuco.api.validator.persona.common;

import co.edu.uco.publiuco.api.validator.Result;
import co.edu.uco.publiuco.api.validator.Validation;
import co.edu.uco.publiuco.utils.UtilText;

public class SegundoApellidoValidation implements Validation<String>{
	private static final int MINIMUN_LENGHT = 1;
	private static final int MAXIMUN_LENGHT = 30;
	private SegundoApellidoValidation() {
		super();
	}
	public static final Result validate(final String data) {
		return new SegundoApellidoValidation().execute(data);
	}
	@Override
	public Result execute(String data) {
		var result = Result.create();
		
		if(UtilText.isEmpty(data)) {
			result.addMessage("No es posible continuar con el segundo apellido vacío");
			
		}else {
			
			if(!UtilText.getUtilText().textHasLenghtAllowed(data, MINIMUN_LENGHT, MAXIMUN_LENGHT)) { 
				result.addMessage("El segundo apellido no puede ser menor a 1 o mayor a 30 caracteres");
			}
			if(!UtilText.getUtilText().textHasOnlyLetters(data)) { 
				result.addMessage("El sengundo apellido solo puede tener letras y espacios");
			}
			
		}
		return result;
	}

}
