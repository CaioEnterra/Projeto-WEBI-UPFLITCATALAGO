package br.com.crudUpFlitCatalago.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.crudUpFlitCatalago.dao.UsuarioDAO;
import br.com.crudUpFlitCatalago.model.Usuario;
import br.com.crudUpFlitCatalago.util.Transacional;


public class UsuarioService implements Serializable {


	
	private static final long serialVersionUID = 481290478297736892L;
	@Inject
	private UsuarioDAO usuarioDAO;
	@Transacional
	public void salvar(Usuario usuario) {
		usuarioDAO.salvar(usuario);
	}
	@Transacional
	public void excluir(Usuario usuario) {
		usuarioDAO.excluir(usuario);
	}

	public List<Usuario> listAll() {
		return usuarioDAO.listAll();
	}

	public Usuario porId(Long id) {
		return usuarioDAO.porId(id);
	}

}