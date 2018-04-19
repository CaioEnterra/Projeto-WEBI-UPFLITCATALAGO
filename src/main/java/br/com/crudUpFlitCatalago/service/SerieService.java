package br.com.crudUpFlitCatalago.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.crudUpFlitCatalago.dao.SerieDAO;
import br.com.crudUpFlitCatalago.model.Serie;
import br.com.crudUpFlitCatalago.util.Transacional;



public class SerieService implements Serializable {


	private static final long serialVersionUID = 5414399138515637926L;
	
	@Inject
	private SerieDAO serieDAO;
	@Transacional
	public void salvar(Serie serie) {
		serieDAO.salvar(serie);
	}
	@Transacional
	public void excluir(Serie serie) {
		serieDAO.excluir(serie);
	}

	public List<Serie> listAll() {
		return serieDAO.listAll();
	}

	public Serie porId(Long id) {
		return serieDAO.porId(id);
	}

}
