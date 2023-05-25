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
import co.edu.uco.publiuco.business.facade.TipoEstadoFacade;
import co.edu.uco.publiuco.business.facade.impl.TipoEstadoFacadeImpl;
import co.edu.uco.publiuco.dto.TipoEstadoDTO;

@RestController
@RequestMapping("publiuco/api/v1/tipoestado")
public final class TipoEstadoController {
	
	private TipoEstadoFacade facade;
	
	@GetMapping("/dummy")
	public TipoEstadoDTO dummy() {
		return TipoEstadoDTO.create();
	}
	@GetMapping
	public ResponseEntity<Response<TipoEstadoDTO>> list(@RequestBody TipoEstadoDTO dto) {
		facade = new TipoEstadoFacadeImpl();

		List<TipoEstadoDTO> list = facade.list(dto);
		
		List<String> messages = new ArrayList<>();
		messages.add("Tipos de estados consultados exitosamente");
		
		Response<TipoEstadoDTO> response = new Response<>(list,messages);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public TipoEstadoDTO listById(@PathVariable UUID id) {
		return TipoEstadoDTO.create().setIdentificador(id);
	}
	
	


	
}
