package co.edu.uco.publiuco.api.validator.comentariolector;

import java.util.UUID;

import co.edu.uco.publiuco.api.validator.Result;
import co.edu.uco.publiuco.api.validator.Validation;
import co.edu.uco.publiuco.api.validator.comentariolector.common.IdentificadorValidation;
import co.edu.uco.publiuco.utils.UtilObject;

public class EliminarComentarioLectorValidation implements Validation<UUID>{
	public static final Result validate(final UUID data) {
		return new EliminarComentarioLectorValidation().execute(data);
	}
	private EliminarComentarioLectorValidation() {
		super();
	}
	
	@Override
	public Result execute(final UUID data) {
		var result = Result.create();
		if(UtilObject.isNull(data)) {
			result.addMessage("No es posible eliminar el comentario");
		}else {
			result.addMessages(IdentificadorValidation.validate(data).getMessages());
		}
		return result;
		
	}
}
