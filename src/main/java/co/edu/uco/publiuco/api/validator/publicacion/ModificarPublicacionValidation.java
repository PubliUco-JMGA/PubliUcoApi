package co.edu.uco.publiuco.api.validator.publicacion;

import co.edu.uco.publiuco.api.validator.Result;
import co.edu.uco.publiuco.api.validator.Validation;
import co.edu.uco.publiuco.api.validator.estado.common.IdentificadorValidation;
import co.edu.uco.publiuco.api.validator.publicacion.common.CategoriaValidation;
import co.edu.uco.publiuco.api.validator.publicacion.common.EstadoValidation;
import co.edu.uco.publiuco.api.validator.publicacion.common.FechaPublicacionValidation;
import co.edu.uco.publiuco.api.validator.publicacion.common.TipoAccesoValidation;
import co.edu.uco.publiuco.api.validator.publicacion.common.VersionPublicadaValidation;
import co.edu.uco.publiuco.dto.PublicacionDTO;
import co.edu.uco.publiuco.utils.UtilObject;

public final class ModificarPublicacionValidation implements Validation<PublicacionDTO>{

	public static final Result validate(final PublicacionDTO data) {
		return new ModificarPublicacionValidation().execute(data);
	}
	private ModificarPublicacionValidation() {
		super();
	}
	
	@Override
	public Result execute(final PublicacionDTO data) {
		var result = Result.create();
		if(UtilObject.isNull(data)) {
			result.addMessage("No es posible modificar la publicación");
		}else {
			result.addMessages(CategoriaValidation.validate(data.getCategoria()).getMessages());
			result.addMessages(IdentificadorValidation.validate(data.getIdentificador()).getMessages());
			result.addMessages(EstadoValidation.validate(data.getEstado()).getMessages());
			result.addMessages(FechaPublicacionValidation.validate(data.getFechaPublicacion()).getMessages());
			result.addMessages(TipoAccesoValidation.validate(data.getTipoAcceso()).getMessages());
			result.addMessages(VersionPublicadaValidation.validate(data.getVersionPublicada()).getMessages());
			
		}
		return result;
		
	}

}
