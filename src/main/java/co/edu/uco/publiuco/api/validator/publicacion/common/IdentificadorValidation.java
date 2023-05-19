package co.edu.uco.publiuco.api.validator.publicacion.common;

import java.util.UUID;

import co.edu.uco.publiuco.api.validator.Result;
import co.edu.uco.publiuco.api.validator.Validation;
import co.edu.uco.publiuco.utils.UtilObject;
import co.edu.uco.publiuco.utils.UtilUUID;

public class IdentificadorValidation implements Validation<UUID> {

	private IdentificadorValidation() {
		super();
	}
	public static final Result validate(final UUID data) {
		return new IdentificadorValidation().execute(data);
	}
	@Override
	public Result execute(UUID data) {
		var result = Result.create();
		
		if(UtilObject.isNull(data)) {
			result.addMessage("No es posible continuar con el identificador de la publicación vacío");
			
		}else if(UtilUUID.isDefault(data)) {
			result.addMessage("No es posible tener el identificador por defecto de la publicación");
		}
		return result;
	}

}
