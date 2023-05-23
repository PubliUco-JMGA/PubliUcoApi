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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.publiuco.api.controller.response.Response;
import co.edu.uco.publiuco.api.validator.publicacion.EliminarPublicacionValidation;
import co.edu.uco.publiuco.api.validator.publicacion.ModificarPublicacionValidation;
import co.edu.uco.publiuco.api.validator.publicacion.RegistrarPublicacionValidation;
import co.edu.uco.publiuco.business.facade.PublicacionFacade;
import co.edu.uco.publiuco.business.facade.impl.PublicacionFacadeImpl;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoException;
import co.edu.uco.publiuco.dto.AdministradorCategoriaDTO;
import co.edu.uco.publiuco.dto.PublicacionDTO;

@RestController
@RequestMapping("publiuco/api/v1/publicacion")
public class PublicacionController {
	private PublicacionFacade facade;
	
	public PublicacionController() {
		facade = new PublicacionFacadeImpl();
	}
	@GetMapping("/dummy")
	public PublicacionDTO dummy() {
		return PublicacionDTO.create();
	}
	
	@GetMapping
	public ResponseEntity<Response<PublicacionDTO>> list(@RequestBody PublicacionDTO dto) {
		List<PublicacionDTO> list = new ArrayList<>();
		
		List<String> messages = new ArrayList<>();
		messages.add("Publicaciones consultadas exitosamente");
		
		Response<PublicacionDTO> response = new Response<>(list,messages);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<Response<PublicacionDTO>> create(@RequestBody PublicacionDTO dto) {
		var statusCode = HttpStatus.OK;
		Response<PublicacionDTO> response = new Response<>();
		
		try {
			var result = RegistrarPublicacionValidation.validate(dto);
			if(result.getMessages().isEmpty()) {
				facade.register(dto);
				response.getMessages().add("La nueva Publicación fue registrada de forma satisfactoria");
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
	public ResponseEntity<Response<AdministradorCategoriaDTO>> update(@PathVariable UUID id, @RequestBody PublicacionDTO dto) {
		var statusCode = HttpStatus.OK;
		var response = new Response<AdministradorCategoriaDTO>();
		
		try {
			var result = ModificarPublicacionValidation.validate(dto);
			if(result.getMessages().isEmpty()) {
				facade.modify(dto);
				response.getMessages().add("La publicación fue modificada de forma satisfactoria");
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
	public ResponseEntity<Response<PublicacionDTO>> drop(@PathVariable UUID id) {
		var statusCode = HttpStatus.OK;
		var response = new Response<PublicacionDTO>();
		
		try {
			var result = EliminarPublicacionValidation.validate(id);
			if(result.getMessages().isEmpty()) {
				facade.drop(id);
				response.getMessages().add("La publicación fue eliminada de forma satisfactoria");
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

