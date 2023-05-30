package co.edu.uco.publiuco.api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.publiuco.api.controller.response.Response;
import co.edu.uco.publiuco.api.validator.calificacion.EliminarCalificacionValidation;
import co.edu.uco.publiuco.api.validator.calificacion.ModificarCalificacionValidation;
import co.edu.uco.publiuco.api.validator.calificacion.RegistrarCalificacionValidation;
import co.edu.uco.publiuco.business.facade.CalificacionFacade;
import co.edu.uco.publiuco.business.facade.impl.CalificacionFacadeImpl;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoException;
import co.edu.uco.publiuco.dto.CalificacionDTO;

@RestController
@RequestMapping("publiuco/api/v1/calificacion")
public class CalificacionController {
	
	private Logger log = LoggerFactory.getLogger(CalificacionController.class);

	private CalificacionFacade facade;
	
	
	@GetMapping("/dummy")
	public CalificacionDTO dummy() {
		return CalificacionDTO.create();
	}
	
	@GetMapping
	public ResponseEntity<Response<CalificacionDTO>> list(@RequestBody CalificacionDTO dto) {
		facade = new CalificacionFacadeImpl();
		List<CalificacionDTO> list = facade.list(dto);
		
		List<String> messages = new ArrayList<>();
		messages.add("Calificaciones consultadas exitosamente");
		
		Response<CalificacionDTO> response = new Response<>(list,messages);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public CalificacionDTO listById(@PathVariable UUID id) {
		return CalificacionDTO.create().setIdentificador(id);
	}
	@PostMapping
	public ResponseEntity<Response<CalificacionDTO>> create(@RequestBody CalificacionDTO dto) {
		facade = new CalificacionFacadeImpl();
		var statusCode = HttpStatus.OK;
		Response<CalificacionDTO> response = new Response<>();
		
		try {
			var result = RegistrarCalificacionValidation.validate(dto);
			if(result.getMessages().isEmpty()) {
				facade.register(dto);
				response.getMessages().add("La calificacion fue registrada de forma satisfactoria");
			}else {
				statusCode = HttpStatus.BAD_REQUEST;
				response.setMessages(result.getMessages());
			}
		}catch (PubliucoException exception) {
			statusCode = HttpStatus.BAD_REQUEST;
			response.getMessages().add(exception.getUserMessage());
			log.error(exception.getType().toString().concat("-").concat(exception.getTechnicalMessage()),exception);
			
		}catch (Exception exception) {
			statusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			response.getMessages().add("Se ha presentado un problema inesperado. Por favor contacte con el administrador del sistema");
			log.error("Se ha presentado un problema inesperado. Por favor, validar la consola");
		}
		
		return new ResponseEntity<>(response,statusCode);
	}
	@PutMapping
	public ResponseEntity<Response<CalificacionDTO>> update(@PathVariable UUID id, @RequestBody CalificacionDTO dto) {
		facade = new CalificacionFacadeImpl();
		var statusCode = HttpStatus.OK;
		var response = new Response<CalificacionDTO>();
		
		try {
			var result = ModificarCalificacionValidation.validate(dto);
			if(result.getMessages().isEmpty()) {
				facade.modify(dto);
				response.getMessages().add("La calificacion fue modificada de forma satisfactoria");
			}else {
				statusCode = HttpStatus.BAD_REQUEST;
				response.setMessages(result.getMessages());
			}
		}catch (PubliucoException exception) {
			statusCode = HttpStatus.BAD_REQUEST;
			response.getMessages().add(exception.getUserMessage());
			log.error(exception.getType().toString().concat("-").concat(exception.getTechnicalMessage()),exception);

			
		}catch (Exception exception) {
			statusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			response.getMessages().add("Se ha presentado un problema inesperado. Por favor contacte con el administrador del sistema");
			log.error("Se ha presentado un problema inesperado. Por favor, validar la consola");

		}
		
		return new ResponseEntity<>(response,statusCode);
	}
	@DeleteMapping
	public ResponseEntity<Response<CalificacionDTO>> drop(@PathVariable UUID id) {
		
		facade = new CalificacionFacadeImpl();var statusCode = HttpStatus.OK;
		var response = new Response<CalificacionDTO>();
		
		try {
			var result = EliminarCalificacionValidation.validate(id);
			if(result.getMessages().isEmpty()) {
				facade.drop(id);
				response.getMessages().add("La calificacion fue eliminada de forma satisfactoria");
			}else {
				statusCode = HttpStatus.BAD_REQUEST;
				response.setMessages(result.getMessages());
			}
		}catch (PubliucoException exception) {
			statusCode = HttpStatus.BAD_REQUEST;
			response.getMessages().add(exception.getUserMessage());
			log.error(exception.getType().toString().concat("-").concat(exception.getTechnicalMessage()),exception);
			
		}catch (Exception exception) {
			statusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			response.getMessages().add("Se ha presentado un problema inesperado. Por favor contacte con el administrador del sistema");
			log.error("Se ha presentado un problema inesperado. Por favor, validar la consola");

		}
		
		return new ResponseEntity<>(response,statusCode);
	}
}
