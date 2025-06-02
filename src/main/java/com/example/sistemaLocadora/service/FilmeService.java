package com.example.sistemaLocadora.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sistemaLocadora.entity.Filme;
import com.example.sistemaLocadora.repository.FilmeRepository;

@Service

public class FilmeService {

	@Autowired
	private FilmeRepository filmeRepository;

	// listar 
	public List<Filme> listar(){
		return filmeRepository.findAll();
	}
	
	//salvar
	public Filme salvar(Filme filme) {
		return filmeRepository.save(filme);
	}
	
	//buscar por id
	public Filme buscarId(Long id) {
		return filmeRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Filme não encontrado"));
		
	}
	 //deletar
	public void deletarId(Long id) {
		filmeRepository.deleteById(id);
	}
	
	
	
	

}
