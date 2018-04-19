package br.com.crudUpFlitCatalago.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.crudUpFlitCatalago.exception.NegocioException;
import br.com.crudUpFlitCatalago.model.Serie;



public class SerieDAO implements Serializable {

	
	
	private static final long serialVersionUID = 228972139585141598L;

	@Inject
	private EntityManager manager;

	// Metodo Salvar
	public Serie salvar(Serie serie) {
		return manager.merge(serie);
	}

	public void excluir(Serie serie) {

		try {
			serie = porId(serie.getId_serie());
			manager.remove(serie);
			manager.flush();

		} catch (Exception e) {
			throw new NegocioException("Serie Não pode ser Excluido");
		}
	}

	public Serie porId(Long id_serie) {

		return manager.find(Serie.class, id_serie);
	}

	public List<Serie> listAll() {
		return manager.createNativeQuery("SELECT * FROM Serie", Serie.class).getResultList();

	}

}