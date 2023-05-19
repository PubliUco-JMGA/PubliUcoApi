package co.edu.uco.publiuco.api.validator.calificacion.common;

import co.edu.uco.publiuco.api.validator.Result;
import co.edu.uco.publiuco.api.validator.Validation;
import co.edu.uco.publiuco.utils.UtilText;

public class CalificacionValidation implements Validation<String> {
	private static final int MINIMUN_LENGHT = 1;
	private static final int MAXIMUN_LENGHT = 5;
	private CalificacionValidation() {
		super();
	}
	public static final Result validate(final String data) {
		return new CalificacionValidation().execute(data);
	}
	@Override
	public Result execute(String data) {
		var result = Result.create();
		
		if(UtilText.isEmpty(data)) {
			result.addMessage("No es posible continuar con una calificación vacía");
		}
		else if(UtilText.getUtilText().textHasLenghtAllowed(data, MINIMUN_LENGHT, MAXIMUN_LENGHT)) { 
			result.addMessage("La calificación debe estar entre 0 y 5");
		}
		return result;
	}
}
