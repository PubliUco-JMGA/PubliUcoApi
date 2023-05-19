package co.edu.uco.publiuco.api.validator.calificacion.common;

import java.time.LocalDateTime;

import co.edu.uco.publiuco.api.validator.Result;
import co.edu.uco.publiuco.api.validator.Validation;
import co.edu.uco.publiuco.utils.UtilDate;
import co.edu.uco.publiuco.utils.UtilObject;

public class FechaCalificacionValidation implements Validation<LocalDateTime>{
	private FechaCalificacionValidation() {
		super();
	}
	public static final Result validate(final LocalDateTime data) {
		return new FechaCalificacionValidation().execute(data);
	}
	@Override
	public Result execute(LocalDateTime data) {
		var result = Result.create();
		
		if(UtilDate.isNull(data)) {
			result.addMessage("No es posible continuar con la fecha de la calificación vacía");
		}
		else if(UtilObject.isDefault(data, UtilDate.getDefaultValue())) {
			result.addMessage("No es posible continuar con la fecha de la calificación con sus valores por defecto");
		}
		return result;
	}
}
