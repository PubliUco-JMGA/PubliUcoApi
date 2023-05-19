package co.edu.uco.publiuco.api.validator.publicacion.common;

import co.edu.uco.publiuco.api.validator.Result;
import co.edu.uco.publiuco.api.validator.Validation;
import co.edu.uco.publiuco.dto.CategoriaDTO;
import co.edu.uco.publiuco.utils.UtilObject;

public class CategoriaValidation implements Validation<CategoriaDTO> {
	private CategoriaValidation() {
		super();
	}
	public static final Result validate(final CategoriaDTO data) {
		return new CategoriaValidation().execute(data);
	}
	@Override
	public Result execute(CategoriaDTO data) {
		var result = Result.create();
		
		if(UtilObject.isNull(data)) {
			result.addMessage("No es posible continuar con la categoría vacia");	
		}
		else if(UtilObject.isDefault(data, CategoriaDTO.create())) {
			result.addMessage("No es posible continuar con la categoría con sus valores por defecto");
		}
		return result;
	}

}
