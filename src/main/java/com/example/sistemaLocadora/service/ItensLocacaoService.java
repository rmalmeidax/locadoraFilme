package com.example.sistemaLocadora.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sistemaLocadora.entity.ItensLocacao;
import com.example.sistemaLocadora.repository.ItensLocacaoRepository;

@Service
public class ItensLocacaoService {
	
	@Autowired
	private ItensLocacaoRepository itensLocacaoRepository;
	
	//listar
	public List<ItensLocacao> listar(){
		return itensLocacaoRepository.findAll();
	}
	
	//salvar
		public ItensLocacao salvar(ItensLocacao itensLocacao){
			return itensLocacaoRepository.save(itensLocacao);
	}

	//buscarId
		public ItensLocacao buscarId(Long id) {
			return itensLocacaoRepository.findById(id)
					.orElseThrow(() -> new RuntimeException("Iten(s) não encontrado"));
		}
	//deletar
		public void deletarId(Long  id) {
			itensLocacaoRepository.deleteById(id);
		}
		
		
		
		
		
	
	

}
