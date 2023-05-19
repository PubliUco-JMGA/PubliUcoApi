package co.edu.uco.publiuco.api.validator.categoria;

import java.util.UUID;

import co.edu.uco.publiuco.api.validator.Result;
import co.edu.uco.publiuco.api.validator.Validation;
import co.edu.uco.publiuco.api.validator.comentariolector.common.IdentificadorValidation;
import co.edu.uco.publiuco.utils.UtilObject;

public class EliminarCategoriaValidation implements Validation<UUID>{
	public static final Result validate(final UUID data) {
		return new EliminarCategoriaValidation().execute(data);
	}
	private EliminarCategoriaValidation() {
		super();
	}
	
	@Override
	public Result execute(final UUID data) {
		var result = Result.create();
		if(UtilObject.isNull(data)) {
			result.addMessage("No es posible eliminar la Categoría");
		}else {
			result.addMessages(IdentificadorValidation.validate(data).getMessages());
		}
		return result;
		
	}

}
