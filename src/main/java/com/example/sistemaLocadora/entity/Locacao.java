package com.example.sistemaLocadora.entity;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_locacao")
public class Locacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private LocalDate dt_locacao;
	private LocalDate dt_dev_prevista;
	private LocalDate dt_dev_real;
	private String situacao;
	
	
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	
	@ManyToOne
	@JoinColumn(name = "filme_id")
	private Filme filme;
	
	
	public Locacao() {
		
	}

	public Locacao(Long id, Cliente cliente, LocalDate dt_locacao, LocalDate dt_dev_prevista,
			LocalDate dt_dev_real, String situacao, Locacao locacao, Filme filme) {
		this.id = id;
		this.cliente = cliente;
		this.dt_locacao = dt_locacao;
		this.dt_dev_prevista = dt_dev_prevista;
		this.dt_dev_real = dt_dev_real;
		this.situacao = situacao;
		this.filme = filme;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public LocalDate getDt_locacao() {
		return dt_locacao;
	}

	public void setDt_locacao(LocalDate dt_locacao) {
		this.dt_locacao = dt_locacao;
	}

	public LocalDate getDt_dev_prevista() {
		return dt_dev_prevista;
	}

	public void setDt_dev_prevista(LocalDate dt_dev_prevista) {
		this.dt_dev_prevista = dt_dev_prevista;
	}

	public LocalDate getDt_dev_real() {
		return dt_dev_real;
	}

	public void setDt_dev_real(LocalDate dt_dev_real) {
		this.dt_dev_real = dt_dev_real;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
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
		Locacao other = (Locacao) obj;
		return Objects.equals(id, other.id);
	}
	
		

}
