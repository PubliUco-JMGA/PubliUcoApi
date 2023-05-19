package co.edu.uco.publiuco.api.validator.lector;

import co.edu.uco.publiuco.api.validator.Result;
import co.edu.uco.publiuco.api.validator.Validation;
import co.edu.uco.publiuco.api.validator.estado.common.IdentificadorValidation;
import co.edu.uco.publiuco.api.validator.lector.common.DatosPersonaValidation;
import co.edu.uco.publiuco.api.validator.lector.common.EstadoValidation;
import co.edu.uco.publiuco.dto.LectorDTO;
import co.edu.uco.publiuco.utils.UtilObject;

public final class RegistrarLectorValidation implements Validation<LectorDTO>{

	public static final Result validate(final LectorDTO data) {
		return new RegistrarLectorValidation().execute(data);
	}
	private RegistrarLectorValidation() {
		super();
	}
	
	@Override
	public Result execute(final LectorDTO data) {
		var result = Result.create();
		if(UtilObject.isNull(data)) {
			result.addMessage("No es posible registrar un nuevo lector");
		}else {
			result.addMessages(DatosPersonaValidation.validate(data.getDatosPersona()).getMessages());
			result.addMessages(EstadoValidation.validate(data.getEstado()).getMessages());
			result.addMessages(IdentificadorValidation.validate(data.getIdentificador()).getMessages());
		}
		return result;
		
	}

}
