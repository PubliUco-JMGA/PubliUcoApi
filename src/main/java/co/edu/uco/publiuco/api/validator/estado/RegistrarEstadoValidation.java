package co.edu.uco.publiuco.api.validator.estado;

import co.edu.uco.publiuco.api.validator.Result;
import co.edu.uco.publiuco.api.validator.Validation;
import co.edu.uco.publiuco.api.validator.estado.common.DescripcionValidation;
import co.edu.uco.publiuco.api.validator.estado.common.NombreValidation;
import co.edu.uco.publiuco.dto.EstadoDTO;
import co.edu.uco.publiuco.utils.UtilObject;

public final class RegistrarEstadoValidation implements Validation<EstadoDTO>{

	public static final Result validate(final EstadoDTO data) {
		return new RegistrarEstadoValidation().execute(data);
	}
	private RegistrarEstadoValidation() {
		super();
	}
	
	@Override
	public Result execute(final EstadoDTO data) {
		var result = Result.create();
		if(UtilObject.isNull(data)) {
			result.addMessage("No es posible registrar un nuevo estado");
		}else {
			result.addMessages(NombreValidation.validate(data.getNombre()).getMessages());
			result.addMessages(DescripcionValidation.validate(data.getNombre()).getMessages());
		}
		return result;
		
	}

}
