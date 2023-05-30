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
import co.edu.uco.publiuco.business.facade.PublicacionFacade;
import co.edu.uco.publiuco.business.facade.impl.PublicacionFacadeImpl;
import co.edu.uco.publiuco.dto.PublicacionDTO;

@RestController
@RequestMapping("publiuco/api/v1/publicacion")
public class PublicacionController {
	private PublicacionFacade facade;
	
	@GetMapping("/dummy")
	public PublicacionDTO dummy() {
		return PublicacionDTO.create();
	}
	
	@GetMapping
	public ResponseEntity<Response<PublicacionDTO>> list(@RequestBody PublicacionDTO dto) {
		facade = new PublicacionFacadeImpl();
		List<PublicacionDTO> list = facade.list(dto);
		
		List<String> messages = new ArrayList<>();
		messages.add("Publicaciones consultadas exitosamente");
		
		Response<PublicacionDTO> response = new Response<>(list,messages);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
}

