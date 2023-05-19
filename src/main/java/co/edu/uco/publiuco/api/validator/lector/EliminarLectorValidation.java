package co.edu.uco.publiuco.api.validator.lector;

import java.util.UUID;

import co.edu.uco.publiuco.api.validator.Result;
import co.edu.uco.publiuco.api.validator.Validation;
import co.edu.uco.publiuco.api.validator.estado.common.IdentificadorValidation;
import co.edu.uco.publiuco.utils.UtilObject;

public final class EliminarLectorValidation implements Validation<UUID>{

	public static final Result validate(final UUID data) {
		return new EliminarLectorValidation().execute(data);
	}
	private EliminarLectorValidation() {
		super();
	}
	
	@Override
	public Result execute(final UUID data) {
		var result = Result.create();
		if(UtilObject.isNull(data)) {
			result.addMessage("No es posible eliminar el lector");
		}else {
			result.addMessages(IdentificadorValidation.validate(data).getMessages());
		}
		return result;
		
	}

}
