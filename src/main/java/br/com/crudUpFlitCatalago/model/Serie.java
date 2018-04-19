package br.com.crudUpFlitCatalago.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
public class Serie implements Serializable {


	private static final long serialVersionUID = 5306014667144376075L;
	// Atributos
	// Mapeamento do Hibernate/ tabela do banco
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id_serie;
	@NotNull  // não deixa a notação ser vazia
	private String nome_serie;
	@NotNull 
	private Genero genero;
	@NotNull 
	private String avaliacao;

	// Metodos get set

	public Long getId_serie() {
		return id_serie;
	}

	public void setId_serie(Long id_serie) {
		this.id_serie = id_serie;
	}

	public String getNome_serie() {
		return nome_serie;
	}

	public void setNome_serie(String nome_serie) {
		this.nome_serie = nome_serie;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public String getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(String avaliacao) {
		this.avaliacao = avaliacao;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_serie == null) ? 0 : id_serie.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Serie other = (Serie) obj;
		if (id_serie == null) {
			if (other.id_serie != null)
				return false;
		} else if (!id_serie.equals(other.id_serie))
			return false;
		return true;
	}

	// verifica se ID foi incluido
	public boolean isInclusao() {
		return getId_serie() == null ? true : false;
	}

	// se não for null é edição
	public boolean isEdicao() {
		return !isInclusao();
	}

}
