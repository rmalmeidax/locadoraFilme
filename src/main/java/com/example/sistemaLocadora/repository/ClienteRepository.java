package com.example.sistemaLocadora.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.sistemaLocadora.entity.Cliente;

@Repository
public interface ClienteRepository  extends JpaRepository<Cliente, Long>{

}
