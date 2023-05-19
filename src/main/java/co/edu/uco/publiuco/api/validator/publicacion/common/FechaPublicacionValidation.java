package co.edu.uco.publiuco.api.validator.publicacion.common;

import java.time.LocalDateTime;

import co.edu.uco.publiuco.api.validator.Result;
import co.edu.uco.publiuco.api.validator.Validation;
import co.edu.uco.publiuco.utils.UtilDate;
import co.edu.uco.publiuco.utils.UtilObject;

public class FechaPublicacionValidation implements Validation<LocalDateTime>{
	private FechaPublicacionValidation() {
		super();
	}
	public static final Result validate(final LocalDateTime data) {
		return new FechaPublicacionValidation().execute(data);
	}
	@Override
	public Result execute(LocalDateTime data) {
		var result = Result.create();
		
		if(UtilDate.isNull(data)) {
			result.addMessage("No es posible continuar con la fecha de la publicación vacía");
		}
		else if(UtilObject.isDefault(data, UtilDate.getDefaultValue())) {
			result.addMessage("No es posible continuar con la fecha de la publicación con sus valores por defecto");
		}
		return result;
	}
}
