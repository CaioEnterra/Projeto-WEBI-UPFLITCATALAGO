package br.com.crudUpFlitCatalago.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.crudUpFlitCatalago.exception.NegocioException;
import br.com.crudUpFlitCatalago.model.Livro;



public class LivroDAO implements Serializable {

	
	private static final long serialVersionUID = 4128925914223674280L;
	@Inject
	private EntityManager manager;

	// Metodo Salvar
	public Livro salvar(Livro livro) {
		return manager.merge(livro);
	}

	public void excluir(Livro livro) {

		try {
			livro = porId(livro.getId_livro());
			manager.remove(livro);
			manager.flush();

		} catch (Exception e) {
			throw new NegocioException("Livro Não pode ser Excluido");
		}
	}

	public Livro porId(Long id_livro) {

		return manager.find(Livro.class, id_livro);
	}

	public List<Livro> listAll() {
		return manager.createNativeQuery("SELECT * FROM Livro", Livro.class).getResultList();

	}

}