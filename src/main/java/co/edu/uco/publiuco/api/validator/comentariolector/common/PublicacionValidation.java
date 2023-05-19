package co.edu.uco.publiuco.api.validator.comentariolector.common;

import co.edu.uco.publiuco.api.validator.Result;
import co.edu.uco.publiuco.api.validator.Validation;
import co.edu.uco.publiuco.dto.ComentarioLectorDTO;
import co.edu.uco.publiuco.dto.PublicacionDTO;
import co.edu.uco.publiuco.utils.UtilObject;

public class PublicacionValidation implements Validation<PublicacionDTO>{
	private PublicacionValidation() {
		super();
	}
	public static final Result validate(final PublicacionDTO data) {
		return new PublicacionValidation().execute(data);
	}
	@Override
	public Result execute(PublicacionDTO data) {
		var result = Result.create();
		
		if(UtilObject.isNull(data)) {
			result.addMessage("No es posible continuar con la publicación vacía");	
		}
		else if(UtilObject.isDefault(data, ComentarioLectorDTO.create())) {
			result.addMessage("No es posible continuar con la publicación con sus valores por defecto");
		}
		return result;
	}
}
