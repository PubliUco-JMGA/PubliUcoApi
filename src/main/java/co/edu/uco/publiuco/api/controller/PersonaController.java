package co.edu.uco.publiuco.api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.publiuco.api.controller.response.Response;
import co.edu.uco.publiuco.api.validator.administradorcategoria.EliminarAdministradorCategoriaValidation;
import co.edu.uco.publiuco.api.validator.persona.ModificarPersonaValidation;
import co.edu.uco.publiuco.api.validator.persona.RegistrarPersonaValidation;
import co.edu.uco.publiuco.business.facade.PersonaFacade;
import co.edu.uco.publiuco.business.facade.impl.PersonaFacadeImpl;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoException;
import co.edu.uco.publiuco.dto.PersonaDTO;

@RestController
@RequestMapping("publiuco/api/v1/administradorcategoria")
public class PersonaController {
	private PersonaFacade facade;
	
	public PersonaController() {
		facade = new PersonaFacadeImpl();
	}
	@GetMapping("/dummy")
	public PersonaDTO dummy() {
		return PersonaDTO.create();
	}
	
	@GetMapping
	public ResponseEntity<Response<PersonaDTO>> list(@RequestParam PersonaDTO dto) {
		List<PersonaDTO> list = new ArrayList<>();
		
		List<String> messages = new ArrayList<>();
		messages.add("Personas consultadas exitosamente");
		
		Response<PersonaDTO> response = new Response<>(list,messages);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<Response<PersonaDTO>> create(@RequestParam PersonaDTO dto) {
		var statusCode = HttpStatus.OK;
		Response<PersonaDTO> response = new Response<>();
		
		try {
			var result = RegistrarPersonaValidation.validate(dto);
			if(result.getMessages().isEmpty()) {
				facade.register(dto);
				response.getMessages().add("La nueva persona fue registrada de forma satisfactoria");
			}else {
				statusCode = HttpStatus.BAD_REQUEST;
				response.setMessages(result.getMessages());
			}
		}catch (PubliucoException exception) {
			statusCode = HttpStatus.BAD_REQUEST;
			response.getMessages().add(exception.getUserMessage());
			System.err.println(exception.getTechnicalMessage());
			System.err.println(exception.getType());
			exception.printStackTrace();
			
		}catch (Exception exception) {
			statusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			response.getMessages().add("Se ha presentado un problema inesperado. Por favor contacte con el administrador del sistema");
			System.err.println(exception.getMessage());
			exception.printStackTrace();
		}
		
		return new ResponseEntity<>(response,statusCode);
	}
	@PutMapping
	public ResponseEntity<Response<PersonaDTO>> update(@PathVariable UUID id, @RequestParam PersonaDTO dto) {
		var statusCode = HttpStatus.OK;
		var response = new Response<PersonaDTO>();
		
		try {
			var result = ModificarPersonaValidation.validate(dto);
			if(result.getMessages().isEmpty()) {
				facade.modify(dto);
				response.getMessages().add("La nueva persona fue modificada de forma satisfactoria");
			}else {
				statusCode = HttpStatus.BAD_REQUEST;
				response.setMessages(result.getMessages());
			}
		}catch (PubliucoException exception) {
			statusCode = HttpStatus.BAD_REQUEST;
			response.getMessages().add(exception.getUserMessage());
			System.err.println(exception.getTechnicalMessage());
			System.err.println(exception.getType());
			exception.printStackTrace();
			
		}catch (Exception exception) {
			statusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			response.getMessages().add("Se ha presentado un problema inesperado. Por favor contacte con el administrador del sistema");
			System.err.println(exception.getMessage());
			exception.printStackTrace();
		}
		
		return new ResponseEntity<>(response,statusCode);
	}
	@DeleteMapping
	public ResponseEntity<Response<PersonaDTO>> drop(@PathVariable UUID id) {
		var statusCode = HttpStatus.OK;
		var response = new Response<PersonaDTO>();
		
		try {
			var result = EliminarAdministradorCategoriaValidation.validate(id);
			if(result.getMessages().isEmpty()) {
				facade.drop(id);
				response.getMessages().add("La persona fue eliminada de forma satisfactoria");
			}else {
				statusCode = HttpStatus.BAD_REQUEST;
				response.setMessages(result.getMessages());
			}
		}catch (PubliucoException exception) {
			statusCode = HttpStatus.BAD_REQUEST;
			response.getMessages().add(exception.getUserMessage());
			System.err.println(exception.getTechnicalMessage());
			System.err.println(exception.getType());
			exception.printStackTrace();
			
		}catch (Exception exception) {
			statusCode = HttpStatus.INTERNAL_SERVER_ERROR;
			response.getMessages().add("Se ha presentado un problema inesperado. Por favor contacte con el administrador del sistema");
			System.err.println(exception.getMessage());
			exception.printStackTrace();
		}
		
		return new ResponseEntity<>(response,statusCode);
	}
}

