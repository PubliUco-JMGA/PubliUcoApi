package co.edu.uco.publiuco.api.validator.persona.common;

import co.edu.uco.publiuco.api.validator.Result;
import co.edu.uco.publiuco.api.validator.Validation;
import co.edu.uco.publiuco.dto.TipoRelacionInstitucionDTO;
import co.edu.uco.publiuco.utils.UtilObject;

public class RelacionInstitucionValidation implements Validation<TipoRelacionInstitucionDTO> {
	private RelacionInstitucionValidation() {
		super();
	}
	public static final Result validate(final TipoRelacionInstitucionDTO data) {
		return new RelacionInstitucionValidation().execute(data);
	}
	@Override
	public Result execute(TipoRelacionInstitucionDTO data) {
		var result = Result.create();
		
		if(UtilObject.isNull(data)) {
			result.addMessage("No es posible continuar con la relación con la institución vacía");	
		}
		else if(UtilObject.isDefault(data, TipoRelacionInstitucionDTO.create())) {
			result.addMessage("No es posible continuar con la relación con las institución con sus valores por defecto");
		}
		return result;
	}

}
