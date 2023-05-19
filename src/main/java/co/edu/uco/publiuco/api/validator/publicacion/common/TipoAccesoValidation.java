package co.edu.uco.publiuco.api.validator.publicacion.common;

import co.edu.uco.publiuco.api.validator.Result;
import co.edu.uco.publiuco.api.validator.Validation;
import co.edu.uco.publiuco.dto.TipoAccesoDTO;
import co.edu.uco.publiuco.dto.TipoEstadoDTO;
import co.edu.uco.publiuco.utils.UtilObject;

public class TipoAccesoValidation implements Validation<TipoAccesoDTO> {
	private TipoAccesoValidation() {
		super();
	}
	public static final Result validate(final TipoAccesoDTO data) {
		return new TipoAccesoValidation().execute(data);
	}
	@Override
	public Result execute(TipoAccesoDTO data) {
		var result = Result.create();
		
		if(UtilObject.isNull(data)) {
			result.addMessage("No es posible continuar con el Tipo de acceso vacío");	
		}
		else if(UtilObject.isDefault(data, TipoAccesoDTO.create())) {
			result.addMessage("No es posible continuar con el Tipo de acceso con sus valores por defecto");
		}
		return result;
	}

}
