package com.example.sistemaLocadora.service;

import java.util.List;
import java.util.Optional;

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
	
	//atualizar
	public Locacao atualizar (Long id, Locacao upLocacao) {
		Optional<Locacao> locacaoExistente = locacaoRepository.findById(id);
		
		if (locacaoExistente.isPresent()) {
			Locacao locacao = locacaoExistente.get();
			locacao.setSituacao(upLocacao.getSituacao());
			locacao.setFilme(upLocacao.getFilme());
			locacao.setCliente(upLocacao.getCliente());
			locacao.setDt_dev_prevista(upLocacao.getDt_dev_prevista());
			locacao.setDt_dev_real(upLocacao.getDt_dev_real());
			locacao.setDt_locacao(upLocacao.getDt_locacao());
			return locacaoRepository.save(locacao);
			
			}
		else {
			
			throw new RuntimeException("Error ao atualizar." + id);			
		} 
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	

}
