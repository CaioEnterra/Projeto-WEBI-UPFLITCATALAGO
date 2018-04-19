package br.com.crudUpFlitCatalago.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.crudUpFlitCatalago.dao.LivroDAO;
import br.com.crudUpFlitCatalago.model.Livro;
import br.com.crudUpFlitCatalago.util.Transacional;



public class LivroService implements Serializable {

	
	private static final long serialVersionUID = -1458675076069934635L;
	@Inject
	private LivroDAO livroDAO;
	@Transacional
	public void salvar(Livro livro) {
		livroDAO.salvar(livro);
	}
	@Transacional
	public void excluir(Livro livro) {
		livroDAO.excluir(livro);
	}

	public List<Livro> listAll() {
		return livroDAO.listAll();
	}

	public Livro porId(Long id) {
		return livroDAO.porId(id);
	}

}