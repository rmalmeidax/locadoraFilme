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

import com.example.sistemaLocadora.entity.Cliente;
import com.example.sistemaLocadora.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteControler {
	
	@Autowired
	private ClienteService clienteService;
	
	//listar
	@GetMapping
	public List<Cliente> listar(){
		return clienteService.listar();
	} 
		
	//salvar
	@PostMapping
	public ResponseEntity<Cliente> salvar(@RequestBody Cliente cliente){
		Cliente newCliente = clienteService.salvar(cliente);
		return ResponseEntity.status(HttpStatus.CREATED).body(newCliente);
		
	}
	
	//buscarId
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> buscarId(@PathVariable Long id){
		Cliente cliente = clienteService.buscarId(id);
		return ResponseEntity.ok(cliente);
	}
		
		//delete
	@DeleteMapping("/{id}")
		public ResponseEntity<Cliente> deletar(@PathVariable Long id){
			clienteService.deletar(id);
			return ResponseEntity.noContent().build();	
		}
	//atualizar
	@PutMapping("/{id}")
	
	public Cliente atualizar (@PathVariable Long id,
			@RequestBody Cliente cliente){
		return clienteService.atualizar(id, cliente);
	}
		
		
	}
