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
public class Filme implements Serializable {


	private static final long serialVersionUID = -5466878940436624185L;
	
	// Atributos
	// Mapeamento do Hibernate/ tabela do banco
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id_filme;
	@NotNull  // não deixa a notação ser vazia
	private String nome_filme;
	@NotNull 
	private Genero genero;
	@NotNull 
	private String avaliacao;

	// Metodos get set

	public Long getId_filme() {
		return id_filme;
	}

	public void setId_filme(Long id_filme) {
		this.id_filme = id_filme;
	}

	public String getNome_filme() {
		return nome_filme;
	}

	public void setNome_filme(String nome_filme) {
		this.nome_filme = nome_filme;
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
		result = prime * result + ((id_filme == null) ? 0 : id_filme.hashCode());
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
		Filme other = (Filme) obj;
		if (id_filme == null) {
			if (other.id_filme != null)
				return false;
		} else if (!id_filme.equals(other.id_filme))
			return false;
		return true;
	}

	// verifica se ID foi incluido
	public boolean isInclusao() {
		return getId_filme() == null ? true : false;
	}

	// se não for null é edição
	public boolean isEdicao() {
		return !isInclusao();
	}

}
