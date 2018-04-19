package br.com.crudUpFlitCatalago.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.crudUpFlitCatalago.exception.NegocioException;
import br.com.crudUpFlitCatalago.model.Usuario;


public class UsuarioDAO implements Serializable {

	private static final long serialVersionUID = -8602406675316034648L;

	@Inject
	private EntityManager manager;

	// Metodo Salvar
	public Usuario salvar(Usuario usuario) {
		return manager.merge(usuario);
	}

	public void excluir(Usuario usuario) {

		try {
			usuario = porId(usuario.getId_usuario());
			manager.remove(usuario);
			manager.flush();

		} catch (Exception e) {
			throw new NegocioException("Usuario Não pode ser Excluido");
		}
	}

	public Usuario porId(Long id_usuario) {

		return manager.find(Usuario.class, id_usuario);
	}

	public List<Usuario> listAll() {
		return manager.createNativeQuery("SELECT * FROM Usuario", Usuario.class).getResultList();

	}

}