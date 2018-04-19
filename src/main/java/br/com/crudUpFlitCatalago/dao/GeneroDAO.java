package br.com.crudUpFlitCatalago.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.crudUpFlitCatalago.exception.NegocioException;
import br.com.crudUpFlitCatalago.model.Genero;

public class GeneroDAO implements Serializable {


	private static final long serialVersionUID = -5617218434925148590L;
	
	@Inject//
	//criador do EntityManager
	private EntityManager manager;

	// Metodo Salvar
	public Genero salvar(Genero genero) {
		return manager.merge(genero);
	}

	public void excluir(Genero genero) {

		try {
			genero = porId(genero.getId_genero());
			manager.remove(genero);
			manager.flush();

		} catch (Exception e) {
			throw new NegocioException("Genero Não pode ser Excluido");
		}
	}

	public Genero porId(Long id_genero) {

		return manager.find(Genero.class, id_genero);
	}

	public List<Genero> listAll() {
		return manager.createNativeQuery("SELECT * FROM Genero", Genero.class).getResultList();

	}

}
