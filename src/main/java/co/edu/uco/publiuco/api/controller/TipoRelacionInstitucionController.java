package co.edu.uco.publiuco.api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.publiuco.api.controller.response.Response;
import co.edu.uco.publiuco.dto.TipoRelacionInstitucionDTO;

@RestController
@RequestMapping("publiuco/api/v1/tiporelacioninstitucion")
public final class TipoRelacionInstitucionController {
	
	
	public TipoRelacionInstitucionController() {
		super();
	}
	@GetMapping("/dummy")
	public TipoRelacionInstitucionDTO dummy() {
		return TipoRelacionInstitucionDTO.create();
	}
	@GetMapping
	public ResponseEntity<Response<TipoRelacionInstitucionDTO>> list(@RequestParam TipoRelacionInstitucionDTO dto) {
		List<TipoRelacionInstitucionDTO> list = new ArrayList<>();
		
		List<String> messages = new ArrayList<>();
		messages.add("Tipos de relación a la institución consultados exitosamente");
		
		Response<TipoRelacionInstitucionDTO> response = new Response<>(list,messages);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public TipoRelacionInstitucionDTO listById(@PathVariable UUID id) {
		return TipoRelacionInstitucionDTO.create().setIdentificador(id);
	}
	
	


	
}
