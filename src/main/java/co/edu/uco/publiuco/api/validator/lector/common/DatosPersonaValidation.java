package co.edu.uco.publiuco.api.validator.lector.common;

import co.edu.uco.publiuco.api.validator.Result;
import co.edu.uco.publiuco.api.validator.Validation;
import co.edu.uco.publiuco.dto.PersonaDTO;
import co.edu.uco.publiuco.utils.UtilObject;

public class DatosPersonaValidation implements Validation<PersonaDTO> {
	private DatosPersonaValidation() {
		super();
	}
	public static final Result validate(final PersonaDTO data) {
		return new DatosPersonaValidation().execute(data);
	}
	@Override
	public Result execute(PersonaDTO data) {
		var result = Result.create();
		
		if(UtilObject.isNull(data)) {
			result.addMessage("No es posible continuar con los datos de la persona vacíos");	
		}
		else if(UtilObject.isDefault(data, PersonaDTO.create())) {
			result.addMessage("No es posible continuar con los datos persona con sus valores por defecto");
		}
		return result;
	}
}
