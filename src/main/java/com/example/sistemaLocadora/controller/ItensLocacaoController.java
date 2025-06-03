package com.example.sistemaLocadora.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sistemaLocadora.entity.ItensLocacao;
import com.example.sistemaLocadora.service.ItensLocacaoService;

@RestController
@RequestMapping("itenslocacao")

public class ItensLocacaoController {
	
	@Autowired
	private ItensLocacaoService itensLocacaoService;
	
	
	//listar
	@GetMapping
	public List<ItensLocacao> listar(){
	return itensLocacaoService.listar();
	}
	
	//salvar
	@PostMapping
	public ResponseEntity<ItensLocacao> salvar
	(@RequestBody ItensLocacao itensLocacao){
	ItensLocacao newItensLocacao = itensLocacaoService.salvar(itensLocacao);
	return ResponseEntity.status(HttpStatus.CREATED).body(itensLocacao);
	
	}
	// buscarId
	@GetMapping("/{id}")
	public ResponseEntity<ItensLocacao> buscarId(@PathVariable Long id){
	ItensLocacao itensLocacao = itensLocacaoService.buscarId(id);	
	return ResponseEntity.ok(itensLocacao);
	
	}
	
	//DeleteId
	public ResponseEntity<ItensLocacao> deletarId(@PathVariable Long id){
		itensLocacaoService.deletarId(id);
		return ResponseEntity.noContent().build()	;	
	}
	
	//atualizar
	@PutMapping("/{id}")
	public ItensLocacao atualizar (@PathVariable Long id,
			@RequestBody ItensLocacao itensLocacao) {
		return itensLocacaoService.atualizar(id, itensLocacao);
	}
	
	
	
	
	
	
	

}
