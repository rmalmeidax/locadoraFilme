package com.example.sistemaLocadora.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sistemaLocadora.entity.Locacao;
import com.example.sistemaLocadora.repository.LocacaoRepository;

@Service
public class LocacaoService {
	
	@Autowired
	private LocacaoRepository locacaoRepository;
	
	//listar
	public List<Locacao> listar(){
		return locacaoRepository.findAll();
	}
	
	//salvar
	public Locacao salvar(Locacao locacao) {
		return locacaoRepository.save(locacao);
	}
	
	//buscarId
	public Locacao buscarId(Long id) {
		return locacaoRepository.findById(id)
				.orElseThrow( () -> new RuntimeException("Locação não encontrada"));
	}
	//deletar
	public void deletarId(Long id) {
		locacaoRepository.deleteById(id);
	}
	
	
	
	
	
	
	
	

}
