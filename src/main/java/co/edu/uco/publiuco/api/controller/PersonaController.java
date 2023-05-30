package co.edu.uco.publiuco.api.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.publiuco.api.controller.response.Response;
import co.edu.uco.publiuco.business.facade.PersonaFacade;
import co.edu.uco.publiuco.business.facade.impl.PersonaFacadeImpl;
import co.edu.uco.publiuco.dto.PersonaDTO;

@RestController
@RequestMapping("publiuco/api/v1/persona")
public class PersonaController {
	private PersonaFacade facade;
	
	@GetMapping("/dummy")
	public PersonaDTO dummy() {
		return PersonaDTO.create();
	}
	
	@GetMapping
	public ResponseEntity<Response<PersonaDTO>> list(@RequestBody PersonaDTO dto) {
		facade = new PersonaFacadeImpl();
		List<PersonaDTO> list = facade.list(dto);
		
		List<String> messages = new ArrayList<>();
		messages.add("Personas consultadas exitosamente");
		
		Response<PersonaDTO> response = new Response<>(list,messages);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
}

