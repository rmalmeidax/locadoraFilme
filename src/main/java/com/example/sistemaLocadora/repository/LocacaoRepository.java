package com.example.sistemaLocadora.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.sistemaLocadora.entity.Locacao;

@Repository
public interface LocacaoRepository extends JpaRepository<Locacao, Long> {

}
