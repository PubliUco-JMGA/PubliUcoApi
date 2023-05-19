package co.edu.uco.publiuco.api.validator.calificacion;

import java.util.UUID;

import co.edu.uco.publiuco.api.validator.Result;
import co.edu.uco.publiuco.api.validator.Validation;
import co.edu.uco.publiuco.api.validator.comentariolector.common.IdentificadorValidation;
import co.edu.uco.publiuco.utils.UtilObject;

public class EliminarCalificacionValidation implements Validation<UUID>{
	public static final Result validate(final UUID data) {
		return new EliminarCalificacionValidation().execute(data);
	}
	private EliminarCalificacionValidation() {
		super();
	}
	
	@Override
	public Result execute(final UUID data) {
		var result = Result.create();
		if(UtilObject.isNull(data)) {
			result.addMessage("No es posible eliminar la calificacion");
		}else {
			result.addMessages(IdentificadorValidation.validate(data).getMessages());

		}
		return result;
		
	}

}
