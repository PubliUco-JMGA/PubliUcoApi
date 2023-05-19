package co.edu.uco.publiuco.api.validator.categoria;

import co.edu.uco.publiuco.api.validator.Result;
import co.edu.uco.publiuco.api.validator.Validation;
import co.edu.uco.publiuco.api.validator.categoria.common.CategoriaPadreValidation;
import co.edu.uco.publiuco.api.validator.categoria.common.DescripcionValidation;
import co.edu.uco.publiuco.api.validator.categoria.common.EstadoValidation;
import co.edu.uco.publiuco.api.validator.categoria.common.NombreValidation;
import co.edu.uco.publiuco.api.validator.comentariolector.common.IdentificadorValidation;
import co.edu.uco.publiuco.dto.CategoriaDTO;
import co.edu.uco.publiuco.utils.UtilObject;

public class RegistrarCategoriaValidation implements Validation<CategoriaDTO>{
	public static final Result validate(final CategoriaDTO data) {
		return new RegistrarCategoriaValidation().execute(data);
	}
	private RegistrarCategoriaValidation() {
		super();
	}
	
	@Override
	public Result execute(final CategoriaDTO data) {
		var result = Result.create();
		if(UtilObject.isNull(data)) {
			result.addMessage("No es posible registrar una nueva Categoría");
		}else {
			result.addMessages(CategoriaPadreValidation.validate(data.getCategoriaPadre()).getMessages());
			result.addMessages(DescripcionValidation.validate(data.getDescripcion()).getMessages());
			result.addMessages(EstadoValidation.validate(data.getEstado()).getMessages());
			result.addMessages(IdentificadorValidation.validate(data.getIdentificador()).getMessages());
			result.addMessages(NombreValidation.validate(data.getNombre()).getMessages());
		}
		return result;
		
	}

}
