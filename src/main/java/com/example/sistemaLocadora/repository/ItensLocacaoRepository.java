package com.example.sistemaLocadora.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.sistemaLocadora.entity.ItensLocacao;

@Repository
public interface ItensLocacaoRepository extends JpaRepository<ItensLocacao,Long>{

}
