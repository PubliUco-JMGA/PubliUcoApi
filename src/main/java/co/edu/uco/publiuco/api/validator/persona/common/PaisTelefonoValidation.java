package co.edu.uco.publiuco.api.validator.persona.common;

import co.edu.uco.publiuco.api.validator.Result;
import co.edu.uco.publiuco.api.validator.Validation;
import co.edu.uco.publiuco.dto.PaisDTO;
import co.edu.uco.publiuco.utils.UtilObject;

public class PaisTelefonoValidation implements Validation<PaisDTO> {
	private PaisTelefonoValidation() {
		super();
	}
	public static final Result validate(final PaisDTO data) {
		return new PaisTelefonoValidation().execute(data);
	}
	@Override
	public Result execute(PaisDTO data) {
		var result = Result.create();
		
		if(UtilObject.isNull(data)) {
			result.addMessage("No es posible continuar con el país del teléfono vacío");	
		}
		else if(UtilObject.isDefault(data, PaisDTO.create())) {
			result.addMessage("No es posible continuar con el país del teléfono con sus valores por defecto");
		}
		return result;
	}

}
