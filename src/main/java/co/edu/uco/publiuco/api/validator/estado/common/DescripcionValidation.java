package co.edu.uco.publiuco.api.validator.estado.common;

import co.edu.uco.publiuco.api.validator.Result;
import co.edu.uco.publiuco.api.validator.Validation;
import co.edu.uco.publiuco.utils.UtilText;

public class DescripcionValidation implements Validation{

	private DescripcionValidation() {
		super();
	}
	public static final Result validate(final String data) {
		return new DescripcionValidation().execute(data);
	}
	@Override
	public Result execute(String data) {
		var result = Result.create();
		
		if(UtilText.getUtilText().isEmpty(data)) {
			result.addMessage("No es posible continuar con la descripción del estado vacío");
			
		}else {
			if(true) { //tarea validar tamaño cadena
				result.addMessage("La descripcion del estado no puede ser mayor a 250 caracteres");
			}
			
			
			
		}
		return result;
	}
	@Override
	public Result execute(Object data) {
		// TODO Auto-generated method stub
		return null;
	}

}
