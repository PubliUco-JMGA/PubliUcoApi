package co.edu.uco.publiuco.api.validator.categoria.common;

import co.edu.uco.publiuco.api.validator.Result;
import co.edu.uco.publiuco.api.validator.Validation;
import co.edu.uco.publiuco.dto.CategoriaDTO;
import co.edu.uco.publiuco.utils.UtilObject;

public class CategoriaPadreValidation implements Validation<CategoriaDTO> {
	private CategoriaPadreValidation() {
		super();
	}
	public static final Result validate(final CategoriaDTO data) {
		return new CategoriaPadreValidation().execute(data);
	}
	@Override
	public Result execute(CategoriaDTO data) {
		var result = Result.create();
		
		if(UtilObject.isNull(data)) {
			result.addMessage("No es posible continuar con la categoría padre vacia");	
		}
		else if(UtilObject.isDefault(data, CategoriaDTO.create())) {
			result.addMessage("No es posible continuar con la categoría padre con sus valores por defecto");
		}
		return result;
	}
}
