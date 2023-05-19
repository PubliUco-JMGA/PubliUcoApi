package co.edu.uco.publiuco.api.validator.persona.common;

import co.edu.uco.publiuco.api.validator.Result;
import co.edu.uco.publiuco.api.validator.Validation;
import co.edu.uco.publiuco.dto.TipoIdentificacionDTO;
import co.edu.uco.publiuco.utils.UtilObject;

public class TipoIdentificacionValidation implements Validation<TipoIdentificacionDTO> {
	private TipoIdentificacionValidation() {
		super();
	}
	public static final Result validate(final TipoIdentificacionDTO data) {
		return new TipoIdentificacionValidation().execute(data);
	}
	@Override
	public Result execute(TipoIdentificacionDTO data) {
		var result = Result.create();
		
		if(UtilObject.isNull(data)) {
			result.addMessage("No es posible continuar con el Tipo de identificación vacío");	
		}
		else if(UtilObject.isDefault(data, TipoIdentificacionDTO.create())) {
			result.addMessage("No es posible continuar con el Tipo de identificación con sus valores por defecto");
		}
		return result;
	}

}
