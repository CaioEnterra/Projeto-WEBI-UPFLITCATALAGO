package br.com.crudUpFlitCatalago.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.crudUpFlitCatalago.exception.NegocioException;
import br.com.crudUpFlitCatalago.model.Filme;


public class FilmeDAO implements Serializable {

	private static final long serialVersionUID = -1086368534359540336L;

	@Inject
	private EntityManager manager;

	// Metodo Salvar
	public Filme salvar(Filme filme) {
		return manager.merge(filme);
	}

	public void excluir(Filme filme) {

		try {
			filme = porId(filme.getId_filme());
			manager.remove(filme);
			manager.flush();

		} catch (Exception e) {
			throw new NegocioException("Filme Não pode ser Excluido");
		}
	}

	public Filme porId(Long id_filme) {

		return manager.find(Filme.class, id_filme);
	}

	public List<Filme> listAll() {
		return manager.createNativeQuery("SELECT * FROM Filme", Filme.class).getResultList();

	}

}