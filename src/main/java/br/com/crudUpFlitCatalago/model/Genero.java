package br.com.crudUpFlitCatalago.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Genero implements Serializable {


	private static final long serialVersionUID = 8164386455731631493L;
	
	// Atributos
	// Mapeamento do Hibernate/ tabela do banco
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//notação especifica no mysq para auto incremente
	@Column
	private Long id_genero;
	@NotNull  // não deixa a notação ser vazia
	private String nome_genero;

	// Metodos get set
	public Long getId_genero() {
		return id_genero;
	}

	public void setId_genero(Long id_genero) {
		this.id_genero = id_genero;
	}

	public String getNome_genero() {
		return nome_genero;
	}

	public void setNome_genero(String nome_genero) {
		this.nome_genero = nome_genero;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_genero == null) ? 0 : id_genero.hashCode());
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
		Genero other = (Genero) obj;
		if (id_genero == null) {
			if (other.id_genero != null)
				return false;
		} else if (!id_genero.equals(other.id_genero))
			return false;
		return true;
	}

	// verifica se ID foi incluido
	public boolean isInclusao() {
		return getId_genero() == null ? true : false;
	}

	// se não for null é edição
	public boolean isEdicao() {
		return !isInclusao();
	}

}
