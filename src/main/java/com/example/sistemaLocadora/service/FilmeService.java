package com.example.sistemaLocadora.service;

import java.util.List;
import java.util.Optional;

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
	
	//atualizar 
	public Filme atualizar (Long id, Filme upFilme) {
		Optional<Filme> filmeExistente = filmeRepository.findById(id);
		
		if (filmeExistente.isPresent()) {
			Filme filme = filmeExistente.get();
			filme.setAnolancamento(upFilme.getAnolancamento());
			filme.setClassificacao(upFilme.getClassificacao());
			filme.setDisponivel(upFilme.getDisponivel());
			filme.setGenero(upFilme.getGenero());
			filme.setTitulo(upFilme.getTitulo());
			return filmeRepository.save(filme);
		}
		else {
			throw new RuntimeException("Error filme não atualizado." + id);
		}
			
			
			
		}
		
		
	}

