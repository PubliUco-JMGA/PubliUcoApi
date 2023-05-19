package co.edu.uco.publiuco.api.validator.comentariolector.common;

import co.edu.uco.publiuco.api.validator.Result;
import co.edu.uco.publiuco.api.validator.Validation;
import co.edu.uco.publiuco.dto.LectorDTO;
import co.edu.uco.publiuco.utils.UtilObject;

public class LectorValidation implements Validation<LectorDTO>{
	private LectorValidation() {
		super();
	}
	public static final Result validate(final LectorDTO data) {
		return new LectorValidation().execute(data);
	}
	@Override
	public Result execute(LectorDTO data) {
		var result = Result.create();
		
		if(UtilObject.isNull(data)) {
			result.addMessage("No es posible continuar con el lector con sus valores vacios");	
		}
		else if(UtilObject.isDefault(data, LectorDTO.create())) {
			result.addMessage("No es posible continuar con el lector con sus valores por defecto");
		}
		return result;
	}
}
