package co.edu.uco.publiuco.api.validator.categoria.common;

import co.edu.uco.publiuco.api.validator.Result;
import co.edu.uco.publiuco.api.validator.Validation;
import co.edu.uco.publiuco.utils.UtilText;

public class DescripcionValidation implements Validation<String>{

	private static final int MINIMUN_LENGHT = 0;
	private static final int MAXIMUN_LENGHT = 200;
	private DescripcionValidation() {
		super();
	}
	public static final Result validate(final String data) {
		return new DescripcionValidation().execute(data);
	}
	@Override
	public Result execute(String data) {
		var result = Result.create();
		
		if(UtilText.isEmpty(data)) {
			result.addMessage("No es posible continuar con la descripción de la categoría vacío");
			
		}else {
			if(UtilText.getUtilText().textHasLenghtAllowed(data, MINIMUN_LENGHT, MAXIMUN_LENGHT)) { 
				result.addMessage("La descripcion de la categoría no puede ser mayor a 200 caracteres");
			}
			
		}
		return result;
	}

}
