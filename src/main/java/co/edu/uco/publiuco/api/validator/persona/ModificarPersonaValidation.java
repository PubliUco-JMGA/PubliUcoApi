package co.edu.uco.publiuco.api.validator.persona;

import co.edu.uco.publiuco.api.validator.Result;
import co.edu.uco.publiuco.api.validator.Validation;
import co.edu.uco.publiuco.api.validator.estado.common.IdentificadorValidation;
import co.edu.uco.publiuco.api.validator.lector.common.EstadoValidation;
import co.edu.uco.publiuco.api.validator.persona.common.CorreoElectronicoValidation;
import co.edu.uco.publiuco.api.validator.persona.common.NumeroIdentificacionValidation;
import co.edu.uco.publiuco.api.validator.persona.common.NumeroTelefonoValidation;
import co.edu.uco.publiuco.api.validator.persona.common.PaisTelefonoValidation;
import co.edu.uco.publiuco.api.validator.persona.common.PrimerApellidoValidation;
import co.edu.uco.publiuco.api.validator.persona.common.PrimerNombreValidation;
import co.edu.uco.publiuco.api.validator.persona.common.RelacionInstitucionValidation;
import co.edu.uco.publiuco.api.validator.persona.common.SegundoApellidoValidation;
import co.edu.uco.publiuco.api.validator.persona.common.SegundoNombreValidation;
import co.edu.uco.publiuco.api.validator.persona.common.TipoIdentificacionValidation;
import co.edu.uco.publiuco.dto.PersonaDTO;
import co.edu.uco.publiuco.utils.UtilObject;

public final class ModificarPersonaValidation implements Validation<PersonaDTO>{

	public static final Result validate(final PersonaDTO data) {
		return new ModificarPersonaValidation().execute(data);
	}
	private ModificarPersonaValidation() {
		super();
	}
	
	@Override
	public Result execute(final PersonaDTO data) {
		var result = Result.create();
		if(UtilObject.isNull(data)) {
			result.addMessage("No es posible modificar la persona");
		}else {
			result.addMessages(CorreoElectronicoValidation.validate(data.getCorreoElectronico()).getMessages());
			result.addMessages(EstadoValidation.validate(data.getEstado()).getMessages());
			result.addMessages(IdentificadorValidation.validate(data.getIdentificador()).getMessages());
			result.addMessages(NumeroIdentificacionValidation.validate(data.getNumeroIdentificacion()).getMessages());
			result.addMessages(NumeroTelefonoValidation.validate(data.getNumeroTelefono()).getMessages());
			result.addMessages(PaisTelefonoValidation.validate(data.getPaisTelefono()).getMessages());
			result.addMessages(PrimerApellidoValidation.validate(data.getPrimerApellido()).getMessages());
			result.addMessages(PrimerNombreValidation.validate(data.getPrimerNombre()).getMessages());
			result.addMessages(RelacionInstitucionValidation.validate(data.getRelacionInstitucion()).getMessages());
			result.addMessages(SegundoApellidoValidation.validate(data.getSegundoApellido()).getMessages());
			result.addMessages(SegundoNombreValidation.validate(data.getSegundoNombre()).getMessages());
			result.addMessages(TipoIdentificacionValidation.validate(data.getTipoIdentificacionDTO()).getMessages());
		}
		return result;
		
	}

}