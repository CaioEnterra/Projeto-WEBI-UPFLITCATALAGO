package br.com.crudUpFlitCatalago.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.crudUpFlitCatalago.dao.FilmeDAO;
import br.com.crudUpFlitCatalago.model.Filme;
import br.com.crudUpFlitCatalago.util.Transacional;



public class FilmeService implements Serializable {

	
	private static final long serialVersionUID = -9082194727503130597L;
	@Inject
	private FilmeDAO filmeDAO;
	@Transacional
	public void salvar(Filme filme) {
		filmeDAO.salvar(filme);
	}
	@Transacional
	public void excluir(Filme filme) {
		filmeDAO.excluir(filme);
	}

	public List<Filme> listAll() {
		return filmeDAO.listAll();
	}

	public Filme porId(Long id) {
		return filmeDAO.porId(id);
	}

}