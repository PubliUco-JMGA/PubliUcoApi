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
import co.edu.uco.publiuco.api.validator.categoria.EliminarCategoriaValidation;
import co.edu.uco.publiuco.api.validator.categoria.ModificarCategoriaValidation;
import co.edu.uco.publiuco.api.validator.categoria.RegistrarCategoriaValidation;
import co.edu.uco.publiuco.business.facade.CategoriaFacade;
import co.edu.uco.publiuco.business.facade.impl.CategoriaFacadeImpl;
import co.edu.uco.publiuco.crosscutting.exception.PubliucoException;
import co.edu.uco.publiuco.dto.AdministradorCategoriaDTO;
import co.edu.uco.publiuco.dto.CategoriaDTO;


@RestController
@RequestMapping("publiuco/api/v1/categoria")
public class CategoriaController {
	private CategoriaFacade facade;
	
	public CategoriaController() {
		facade = new CategoriaFacadeImpl();
	}
	@GetMapping("/dummy")
	public AdministradorCategoriaDTO dummy() {
		return AdministradorCategoriaDTO.create();
	}
	
	@GetMapping
	public ResponseEntity<Response<CategoriaDTO>> list(@RequestParam CategoriaDTO dto) {
		List<CategoriaDTO> list = new ArrayList<>();
		
		List<String> messages = new ArrayList<>();
		messages.add("Categorias consultadas exitosamente");
		
		Response<CategoriaDTO> response = new Response<>(list,messages);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<Response<CategoriaDTO>> create(@RequestParam CategoriaDTO dto) {
		var statusCode = HttpStatus.OK;
		Response<CategoriaDTO> response = new Response<>();
		
		try {
			var result = RegistrarCategoriaValidation.validate(dto);
			if(result.getMessages().isEmpty()) {
				facade.register(dto);
				response.getMessages().add("La nueva categoría fue registrada de forma satisfactoria");
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
	public ResponseEntity<Response<CategoriaDTO>> update(@PathVariable UUID id, @RequestParam CategoriaDTO dto) {
		var statusCode = HttpStatus.OK;
		var response = new Response<CategoriaDTO>();
		
		try {
			var result = ModificarCategoriaValidation.validate(dto);
			if(result.getMessages().isEmpty()) {
				facade.modify(dto);
				response.getMessages().add("El administrador categoria fue modificado de forma satisfactoria");
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
	public ResponseEntity<Response<CategoriaDTO>> drop(@PathVariable UUID id) {
		var statusCode = HttpStatus.OK;
		var response = new Response<CategoriaDTO>();
		
		try {
			var result = EliminarCategoriaValidation.validate(id);
			if(result.getMessages().isEmpty()) {
				facade.drop(id);
				response.getMessages().add("La categoría fue eliminada de forma satisfactoria");
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
