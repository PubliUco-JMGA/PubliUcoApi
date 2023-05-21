package co.edu.uco.publiuco.api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.publiuco.api.controller.response.Response;
import co.edu.uco.publiuco.dto.EstadoDTO;
import co.edu.uco.publiuco.dto.PaisDTO;

@RestController
@RequestMapping("publiuco/api/v1/pais")
public final class PaisController {
	
	
	public PaisController() {
		super();
	}
	@GetMapping("/dummy")
	public PaisDTO dummy() {
		return PaisDTO.create();
	}
	@GetMapping
	public ResponseEntity<Response<EstadoDTO>> list(@RequestBody PaisDTO dto) {
		List<EstadoDTO> list = new ArrayList<>();
		
		List<String> messages = new ArrayList<>();
		messages.add("Países de telefonos consultados exitosamente");
		
		Response<EstadoDTO> response = new Response<>(list,messages);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public PaisDTO listById(@PathVariable UUID id) {
		return PaisDTO.create().setIdentificador(id);
	}
	
	


	
}
