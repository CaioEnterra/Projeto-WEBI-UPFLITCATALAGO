package br.com.crudUpFlitCatalago.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.crudUpFlitCatalago.dao.GeneroDAO;
import br.com.crudUpFlitCatalago.model.Genero;
import br.com.crudUpFlitCatalago.util.Transacional;

public class GeneroService implements Serializable {

	
	private static final long serialVersionUID = -2079824105621634536L;
	@Inject
	private GeneroDAO generoDAO;
	@Transacional
	public void salvar(Genero genero) {
		generoDAO.salvar(genero);
	}
	@Transacional
	public void excluir(Genero genero) {
		generoDAO.excluir(genero);
	}

	public List<Genero> listAll() {
		return generoDAO.listAll();
	}

	public Genero porId(Long id) {
		return generoDAO.porId(id);
	}

}
