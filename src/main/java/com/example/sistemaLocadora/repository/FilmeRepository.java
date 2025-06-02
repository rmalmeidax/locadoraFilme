package com.example.sistemaLocadora.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.sistemaLocadora.entity.Filme;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Long>{
	
	

}
