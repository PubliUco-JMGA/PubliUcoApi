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
import co.edu.uco.publiuco.dto.VersionDTO;

@RestController
@RequestMapping("publiuco/api/v1/version")
public class VersionController {
	@GetMapping
	public ResponseEntity<Response<VersionDTO>> list(@RequestBody VersionDTO dto) {
		List<VersionDTO> list = new ArrayList<>();
		
		List<String> messages = new ArrayList<>();
		messages.add("Versiones consultadas exitosamente");
		
		Response<VersionDTO> response = new Response<>(list,messages);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
}
