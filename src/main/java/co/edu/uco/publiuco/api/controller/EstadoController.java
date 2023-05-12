package co.edu.uco.publiuco.api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.publiuco.dto.EstadoDTO;

@RestController
@RequestMapping("publiuco/api/v1/estado")
public final class EstadoController {
	
	@GetMapping("/dummy")
	public EstadoDTO dummy() {
		return EstadoDTO.create();
	}
	
	@GetMapping
	public List<EstadoDTO> list(@RequestParam EstadoDTO dto) {
		List<EstadoDTO> list = new ArrayList<>();
		return list;
	}
	@GetMapping("/{id}")
	public EstadoDTO listById(@PathVariable UUID id) {
		return EstadoDTO.create().setIdentificador(id);
	}
	@PostMapping
	public EstadoDTO create(@RequestParam EstadoDTO dto) {
		return dto;
	}
	@PutMapping
	public EstadoDTO update(@PathVariable UUID id, @RequestParam EstadoDTO dto) {
		return dto.setIdentificador(id);
	}
	@DeleteMapping
	public EstadoDTO create(@PathVariable UUID id) {
		return EstadoDTO.create().setIdentificador(id);
	}
}
