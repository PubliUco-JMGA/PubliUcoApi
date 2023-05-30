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
import co.edu.uco.publiuco.business.facade.LectorFacade;
import co.edu.uco.publiuco.business.facade.impl.LectorFacadeImpl;
import co.edu.uco.publiuco.dto.LectorDTO;

@RestController
@RequestMapping("publiuco/api/v1/lector")
public class LectorController {

	
	@GetMapping("/dummy")
	public LectorDTO dummy() {
		return LectorDTO.create();
	}
	
	@GetMapping
	public ResponseEntity<Response<LectorDTO>> list(@RequestBody LectorDTO dto) {
		LectorFacade facade = new LectorFacadeImpl();
		
		List<LectorDTO> list = facade.list(dto);
		
		List<String> messages = new ArrayList<>();
		messages.add("Lectores consultados exitosamente");
		
		Response<LectorDTO> response = new Response<>(list,messages);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
}

