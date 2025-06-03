package com.example.sistemaLocadora.service;

import java.util.List;
import java.util.Optional;

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
	//atualizar
	public Cliente atualizar (Long id, Cliente upCliente) {
		Optional<Cliente> clienteExistente = clienteRepository.findById(id); 
		
		//verificar se o cliente existe 
		
		if (clienteExistente.isPresent()) {
			Cliente cliente = clienteExistente.get();
			cliente.setNome(upCliente.getNome());
			cliente.setCpf(upCliente.getCpf());
			cliente.setData(upCliente.getData());
			cliente.setEmail(upCliente.getEmail());
			cliente.setEndereco(upCliente.getEndereco());
			cliente.setTelefone(upCliente.getTelefone());
			return clienteRepository.save(upCliente);
		}
		else {
			throw new RuntimeException("Error ao atualizar." + id);
			
		}
	
	}
		
}
	