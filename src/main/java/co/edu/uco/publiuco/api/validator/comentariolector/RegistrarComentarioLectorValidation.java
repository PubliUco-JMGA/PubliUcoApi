package co.edu.uco.publiuco.api.validator.comentariolector;

import co.edu.uco.publiuco.api.validator.Result;
import co.edu.uco.publiuco.api.validator.Validation;
import co.edu.uco.publiuco.api.validator.comentariolector.common.ComentarioLectorValidation;
import co.edu.uco.publiuco.api.validator.comentariolector.common.ContenidoValidation;
import co.edu.uco.publiuco.api.validator.comentariolector.common.EstadoValidation;
import co.edu.uco.publiuco.api.validator.comentariolector.common.FechaComentarioValidation;
import co.edu.uco.publiuco.api.validator.comentariolector.common.IdentificadorValidation;
import co.edu.uco.publiuco.api.validator.comentariolector.common.LectorValidation;
import co.edu.uco.publiuco.api.validator.comentariolector.common.PublicacionValidation;
import co.edu.uco.publiuco.dto.ComentarioLectorDTO;
import co.edu.uco.publiuco.utils.UtilObject;

public class RegistrarComentarioLectorValidation implements Validation<ComentarioLectorDTO>{
	public static final Result validate(final ComentarioLectorDTO data) {
		return new RegistrarComentarioLectorValidation().execute(data);
	}
	private RegistrarComentarioLectorValidation() {
		super();
	}
	
	@Override
	public Result execute(final ComentarioLectorDTO data) {
		var result = Result.create();
		if(UtilObject.isNull(data)) {
			result.addMessage("No es posible registrar un nuevo comentario");
		}else {
			result.addMessages(ContenidoValidation.validate(data.getCotenido()).getMessages());
			result.addMessages(EstadoValidation.validate(data.getEstado()).getMessages());
			result.addMessages(FechaComentarioValidation.validate(data.getFechaComentario()).getMessages());
			result.addMessages(IdentificadorValidation.validate(data.getIdentificador()).getMessages());
			result.addMessages(LectorValidation.validate(data.getLector()).getMessages());
			result.addMessages(PublicacionValidation.validate(data.getPublicacion()).getMessages());
		}
		return result;
		
	}

}
