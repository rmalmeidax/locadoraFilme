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

import com.example.sistemaLocadora.entity.Locacao;
import com.example.sistemaLocadora.service.LocacaoService;

@RestController
@RequestMapping("/locacao")
public class LocacaoController {
	
	@Autowired
	private LocacaoService locacaoService;
	
	//listar
	@GetMapping
	public List<Locacao> listar(){
		return locacaoService.listar();
	}
	
	//salvar
	@PostMapping
	public ResponseEntity<Locacao> salvar(@RequestBody Locacao locacao){
	Locacao newLocacao = locacaoService.salvar(locacao);
	return ResponseEntity.status(HttpStatus.CREATED).body(newLocacao);
	}
	
	//buscarId
	@GetMapping("/{id}")
	public ResponseEntity<Locacao> buscarId(@PathVariable Long id){
		Locacao locacao =  locacaoService.buscarId(id);
		return ResponseEntity.ok(locacao);
	}
	
	//DeletarId
	@DeleteMapping("/{id}")
	public ResponseEntity<Locacao> deletarId(@PathVariable Long id){
		locacaoService.deletarId(id);
		return ResponseEntity.noContent().build();
	}
	
	//atualizar 
	@PutMapping("/{id}")
	public Locacao atualizar(@PathVariable Long id,
			@RequestBody Locacao locacao) {
		return locacaoService.atualizar(id, locacao);
	}
	
	
	
	
	
	

}
