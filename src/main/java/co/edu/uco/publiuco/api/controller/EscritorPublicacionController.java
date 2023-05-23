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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.publiuco.api.controller.response.Response;
import co.edu.uco.publiuco.dto.EscritorPublicacionDTO;

@RestController
@RequestMapping("publiuco/api/v1/escritorpublicacion")
public class EscritorPublicacionController {
	@GetMapping("/dummy")
	public EscritorPublicacionDTO dummy() {
		return EscritorPublicacionDTO.create();
	}
	
	@GetMapping
	public ResponseEntity<Response<EscritorPublicacionDTO>> list(@RequestBody EscritorPublicacionDTO dto) {
		List<EscritorPublicacionDTO> list = new ArrayList<>();
		
		List<String> messages = new ArrayList<>();
		messages.add("Escritores Publicación consultados exitosamente");
		
		Response<EscritorPublicacionDTO> response = new Response<>(list,messages);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public EscritorPublicacionDTO listById(@PathVariable UUID id) {
		return EscritorPublicacionDTO.create().setIdentificador(id);
	}
	@PostMapping
	public EscritorPublicacionDTO create(@RequestParam EscritorPublicacionDTO dto) {
		return dto;
	}
	@PutMapping
	public EscritorPublicacionDTO update(@PathVariable UUID id, @RequestParam EscritorPublicacionDTO dto) {
		return dto.setIdentificador(id);
	}
	@DeleteMapping
	public EscritorPublicacionDTO create(@PathVariable UUID id) {
		return EscritorPublicacionDTO.create().setIdentificador(id);
	}
}
