package co.edu.uco.publiuco.api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.edu.uco.publiuco.dto.AdministradorCategoriaDTO;

public class AdministradorCategoriaController {
	@GetMapping("/dummy")
	public AdministradorCategoriaDTO dummy() {
		return AdministradorCategoriaDTO.create();
	}
	
	@GetMapping
	public List<AdministradorCategoriaDTO> list(@RequestParam AdministradorCategoriaDTO dto) {
		List<AdministradorCategoriaDTO> list = new ArrayList<>();
		return list;
	}
	@GetMapping("/{id}")
	public AdministradorCategoriaDTO listById(@PathVariable UUID id) {
		return AdministradorCategoriaDTO.create().setIdentificador(id);
	}
	@PostMapping
	public AdministradorCategoriaDTO create(@RequestParam AdministradorCategoriaDTO dto) {
		return dto;
	}
	@PutMapping
	public AdministradorCategoriaDTO update(@PathVariable UUID id, @RequestParam AdministradorCategoriaDTO dto) {
		return dto.setIdentificador(id);
	}
	@DeleteMapping
	public AdministradorCategoriaDTO create(@PathVariable UUID id) {
		return AdministradorCategoriaDTO.create().setIdentificador(id);
	}
}
