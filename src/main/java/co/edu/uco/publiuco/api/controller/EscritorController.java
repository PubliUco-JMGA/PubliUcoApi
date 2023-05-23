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
import co.edu.uco.publiuco.dto.EscritorDTO;

@RestController
@RequestMapping("publiuco/api/v1/escritor")
public class EscritorController {
	@GetMapping("/dummy")
	public EscritorDTO dummy() {
		return EscritorDTO.create();
	}
	
	@GetMapping
	public ResponseEntity<Response<EscritorDTO>> list(@RequestBody EscritorDTO dto) {
		List<EscritorDTO> list = new ArrayList<>();
		
		List<String> messages = new ArrayList<>();
		messages.add("Escritores consultados exitosamente");
		
		Response<EscritorDTO> response = new Response<>(list,messages);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public EscritorDTO listById(@PathVariable UUID id) {
		return EscritorDTO.create().setIdentificador(id);
	}
	@PostMapping
	public EscritorDTO create(@RequestParam EscritorDTO dto) {
		return dto;
	}
	@PutMapping
	public EscritorDTO update(@PathVariable UUID id, @RequestParam EscritorDTO dto) {
		return dto.setIdentificador(id);
	}
	@DeleteMapping
	public EscritorDTO create(@PathVariable UUID id) {
		return EscritorDTO.create().setIdentificador(id);
	}
}
