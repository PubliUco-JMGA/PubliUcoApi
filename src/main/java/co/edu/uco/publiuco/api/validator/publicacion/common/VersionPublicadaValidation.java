package co.edu.uco.publiuco.api.validator.publicacion.common;

import co.edu.uco.publiuco.api.validator.Result;
import co.edu.uco.publiuco.api.validator.Validation;
import co.edu.uco.publiuco.dto.VersionDTO;
import co.edu.uco.publiuco.utils.UtilObject;

public class VersionPublicadaValidation implements Validation<VersionDTO> {
	private VersionPublicadaValidation() {
		super();
	}
	public static final Result validate(final VersionDTO data) {
		return new VersionPublicadaValidation().execute(data);
	}
	@Override
	public Result execute(VersionDTO data) {
		var result = Result.create();
		
		if(UtilObject.isNull(data)) {
			result.addMessage("No es posible continuar con la versión publicada vacía");	
		}
		else if(UtilObject.isDefault(data, VersionDTO.create())) {
			result.addMessage("No es posible continuar con la versión publicada con sus valores por defecto");
		}
		return result;
	}

}
