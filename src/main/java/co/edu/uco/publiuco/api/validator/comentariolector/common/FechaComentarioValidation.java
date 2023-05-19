package co.edu.uco.publiuco.api.validator.comentariolector.common;

import java.time.LocalDateTime;

import co.edu.uco.publiuco.api.validator.Result;
import co.edu.uco.publiuco.api.validator.Validation;
import co.edu.uco.publiuco.utils.UtilDate;
import co.edu.uco.publiuco.utils.UtilObject;

public class FechaComentarioValidation implements Validation<LocalDateTime>{
	private FechaComentarioValidation() {
		super();
	}
	public static final Result validate(final LocalDateTime data) {
		return new FechaComentarioValidation().execute(data);
	}
	@Override
	public Result execute(LocalDateTime data) {
		var result = Result.create();
		
		if(UtilDate.isNull(data)) {
			result.addMessage("No es posible continuar con la fecha del comentario vacía");
		}
		else if(UtilObject.isDefault(data, UtilDate.getDefaultValue())) {
			result.addMessage("No es posible continuar con la fecha del comentario con sus valores por defecto");
		}
		return result;
	}
}
