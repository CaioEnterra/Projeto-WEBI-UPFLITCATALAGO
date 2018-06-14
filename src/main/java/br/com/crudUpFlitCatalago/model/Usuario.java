package br.com.crudUpFlitCatalago.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;



@Entity
public class Usuario implements Serializable {

	
	private static final long serialVersionUID = 4222133914778443022L;
	
	// Atributos
	// Mapeamento do Hibernate/ tabela do banco
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id_usuario;
	@NotNull  // não deixa a notação ser vazia
	private String nome_usuario;
	@NotNull  // não deixa a notação ser vazia
	private String cpf;
	@NotNull  // não deixa a notação ser vazia
	private String email;

	// Metodos get set
	public Long getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getNome_usuario() {
		return nome_usuario;
	}

	public void setNome_usuario(String nome_usuario) {
		this.nome_usuario = nome_usuario;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_usuario == null) ? 0 : id_usuario.hashCode());
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
		Usuario other = (Usuario) obj;
		if (id_usuario == null) {
			if (other.id_usuario != null)
				return false;
		} else if (!id_usuario.equals(other.id_usuario))
			return false;
		return true;
	}

	// verifica se ID foi incluido
	public boolean isInclusao() {
		return getId_usuario() == null ? true : false;
	}

	// se não for null é edição
	public boolean isEdicao() {
		return !isInclusao();
	}

}
