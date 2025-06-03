package com.example.sistemaLocadora.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sistemaLocadora.entity.Filme;
import com.example.sistemaLocadora.service.FilmeService;

@RestController
@RequestMapping("/filme")

public class FilmeController {
	
	@Autowired
	private FilmeService filmeService;
	
	//listar
	@GetMapping
	public List<Filme> listar(){
		return filmeService.listar();
	}
	
	
	//buscarId
	@GetMapping("/{id}")
	public ResponseEntity<Filme> buscarId(@PathVariable Long id){
		Filme filme = filmeService.buscarId(id);
		return ResponseEntity.ok(filme);
	}
	
	//salvar
	@PostMapping
	public ResponseEntity<Filme> salvar(@RequestBody Filme filme){
		Filme newFilme = filmeService.salvar(filme);
		return ResponseEntity.status(HttpStatus.CREATED).body(newFilme);
		
	}	
	
	// delete
	@DeleteMapping("/{id}")
	public ResponseEntity<Filme> deleteId(@PathVariable Long id) {
		filmeService.deletarId(id);
		return ResponseEntity.noContent().build();
	}
	//atualizar
	@PutMapping("/{id}")
	public Filme atualizar (@PathVariable Long id,
			@RequestBody Filme filme) {
	return filmeService.atualizar(id, filme);
	}
		
		
		
}
	
	
	
	


