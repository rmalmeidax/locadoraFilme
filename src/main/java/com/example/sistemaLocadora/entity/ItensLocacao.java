package com.example.sistemaLocadora.entity;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_itenslocacao")

public class ItensLocacao {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToMany(mappedBy = "locacao")
	private List<Locacao> locacao;
	
	@OneToMany(mappedBy = "filme" )
	private List<Filme> filme;
	
	private Double valor;

	public ItensLocacao() {
		
	}

	public ItensLocacao(Long id, List<Locacao> locacao, List<Filme> filme, Double valor) {
		
		this.id = id;
		this.locacao = locacao;
		this.filme = filme;
		this.valor = valor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Locacao> getLocacao() {
		return locacao;
	}

	public void setLocacao(List<Locacao> locacao) {
		this.locacao = locacao;
	}

	public List<Filme> getFilme() {
		return filme;
	}

	public void setFilme(List<Filme> filme) {
		this.filme = filme;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItensLocacao other = (ItensLocacao) obj;
		return Objects.equals(id, other.id);
	}	
	
	
}
