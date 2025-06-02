package com.example.sistemaLocadora.entity;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_filmes")
public class Filme {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private  String titulo;
	private String genero;
	private Integer anolancamento;
	private String classificacao;
	private Boolean disponivel;
	
	public Filme() {
		
	}

	public Filme(Long id, String titulo, String genero, Integer anolancamento, String classificacao,
			Boolean disponivel) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.genero = genero;
		this.anolancamento = anolancamento;
		this.classificacao = classificacao;
		this.disponivel = disponivel;
		
		}
	
	@ManyToOne
	@JoinColumn(name = "filme_id")
	private Filme filme;
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Integer getAnolancamento() {
		return anolancamento;
	}

	public void setAnolancamento(Integer anolancamento) {
		this.anolancamento = anolancamento;
	}

	public String getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	}

	public Boolean getDisponivel() {
		return disponivel;
	}

	public void setDisponivel(Boolean disponivel) {
		this.disponivel = disponivel;
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
		Filme other = (Filme) obj;
		return Objects.equals(id, other.id);
	}
	
		

}
