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
public class Livro implements Serializable {


	private static final long serialVersionUID = -7713732209226427606L;
	
	// Mapeamento do Hibernate/ tabela do banco
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id_livro;
	@NotNull  // não deixa a notação ser vazia
	private String nome_livro;
	@NotNull 
	private Genero genero;
	@NotNull 
	private String autor;
	@NotNull 
	private String avaliacao;

	// Metodos get set
	public Long getId_livro() {
		return id_livro;
	}
	public void setId_livro(Long id_livro) {
		this.id_livro = id_livro;
	}
	public String getNome_livro() {
		return nome_livro;
	}
	public void setNome_livro(String nome_livro) {
		this.nome_livro = nome_livro;
	}
	public Genero getGenero() {
		return genero;
	}
	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
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
		result = prime * result + ((id_livro == null) ? 0 : id_livro.hashCode());
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
		Livro other = (Livro) obj;
		if (id_livro == null) {
			if (other.id_livro != null)
				return false;
		} else if (!id_livro.equals(other.id_livro))
			return false;
		return true;
	}

	// verifica se ID foi incluido
	public boolean isInclusao() {
		return getId_livro() == null ? true : false;
	}

	// se não for null é edição
	public boolean isEdicao() {
		return !isInclusao();
	}

}
