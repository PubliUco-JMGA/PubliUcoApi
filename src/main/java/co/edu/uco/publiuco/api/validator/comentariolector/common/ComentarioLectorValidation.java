package co.edu.uco.publiuco.api.validator.comentariolector.common;

import co.edu.uco.publiuco.api.validator.Result;
import co.edu.uco.publiuco.api.validator.Validation;
import co.edu.uco.publiuco.dto.ComentarioLectorDTO;
import co.edu.uco.publiuco.utils.UtilObject;

public class ComentarioLectorValidation implements Validation<ComentarioLectorDTO>{
	private ComentarioLectorValidation() {
		super();
	}
	public static final Result validate(final ComentarioLectorDTO data) {
		return new ComentarioLectorValidation().execute(data);
	}
	@Override
	public Result execute(ComentarioLectorDTO data) {
		var result = Result.create();
		
		if(UtilObject.isNull(data)) {
			result.addMessage("No es posible continuar con el Comentario vacío");	
		}
		else if(UtilObject.isDefault(data, ComentarioLectorDTO.create())) {
			result.addMessage("No es posible continuar con el Comentario con sus valores por defecto");
		}
		return result;
	}
}
