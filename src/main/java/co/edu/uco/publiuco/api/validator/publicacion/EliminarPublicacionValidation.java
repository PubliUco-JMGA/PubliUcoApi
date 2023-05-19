package co.edu.uco.publiuco.api.validator.publicacion;

import java.util.UUID;

import co.edu.uco.publiuco.api.validator.Result;
import co.edu.uco.publiuco.api.validator.Validation;
import co.edu.uco.publiuco.api.validator.estado.common.IdentificadorValidation;
import co.edu.uco.publiuco.utils.UtilObject;

public final class EliminarPublicacionValidation implements Validation<UUID>{

	public static final Result validate(final UUID data) {
		return new EliminarPublicacionValidation().execute(data);
	}
	private EliminarPublicacionValidation() {
		super();
	}
	
	@Override
	public Result execute(final UUID data) {
		var result = Result.create();
		if(UtilObject.isNull(data)) {
			result.addMessage("No es posible eliminar la publicación");
		}else {
			result.addMessages(IdentificadorValidation.validate(data).getMessages());
			
		}
		return result;
		
	}

}
