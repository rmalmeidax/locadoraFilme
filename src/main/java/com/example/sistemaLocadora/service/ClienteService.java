package com.example.sistemaLocadora.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sistemaLocadora.entity.Cliente;
import com.example.sistemaLocadora.repository.ClienteRepository;

@Service
public class ClienteService {
	
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	// listar
	public List<Cliente> listar(){
		return clienteRepository.findAll();
	}
	
	//salvar
	public Cliente salvar (Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	// buscarId
	public Cliente buscarId(Long id) {
		return clienteRepository.findById(id)
			.orElseThrow(() -> new RuntimeException
					("Clinete não encontrado"));
	}
	
	//deletar
	public void deletar(Long id) {
		clienteRepository.deleteById(id);
	}
	

}
