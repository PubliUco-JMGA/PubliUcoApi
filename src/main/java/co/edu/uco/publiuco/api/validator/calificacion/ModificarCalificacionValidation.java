package co.edu.uco.publiuco.api.validator.calificacion;

import co.edu.uco.publiuco.api.validator.Result;
import co.edu.uco.publiuco.api.validator.Validation;
import co.edu.uco.publiuco.api.validator.calificacion.common.CalificacionValidation;
import co.edu.uco.publiuco.api.validator.calificacion.common.FechaCalificacionValidation;
import co.edu.uco.publiuco.api.validator.comentariolector.common.IdentificadorValidation;
import co.edu.uco.publiuco.api.validator.comentariolector.common.LectorValidation;
import co.edu.uco.publiuco.api.validator.comentariolector.common.PublicacionValidation;
import co.edu.uco.publiuco.dto.CalificacionDTO;
import co.edu.uco.publiuco.utils.UtilObject;

public class ModificarCalificacionValidation implements Validation<CalificacionDTO>{
	public static final Result validate(final CalificacionDTO data) {
		return new ModificarCalificacionValidation().execute(data);
	}
	private ModificarCalificacionValidation() {
		super();
	}
	
	@Override
	public Result execute(final CalificacionDTO data) {
		var result = Result.create();
		if(UtilObject.isNull(data)) {
			result.addMessage("No es posible modificar la calificacion");
		}else {
			result.addMessages(CalificacionValidation.validate(data.getCalificacion()).getMessages());
			result.addMessages(FechaCalificacionValidation.validate(data.getFechaCalificacion()).getMessages());
			result.addMessages(IdentificadorValidation.validate(data.getIdentificador()).getMessages());
			result.addMessages(LectorValidation.validate(data.getLector()).getMessages());
			result.addMessages(PublicacionValidation.validate(data.getPublicacion()).getMessages());
		}
		return result;
		
	}

}
