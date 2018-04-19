package br.com.crudUpFlitCatalago.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.crudUpFlitCatalago.model.Usuario;
import br.com.crudUpFlitCatalago.service.UsuarioService;
import br.com.crudUpFlitCatalago.util.FacesUtil;


@Named
@ViewScoped
public class ListaUsuarioMB implements Serializable{
	

	private static final long serialVersionUID = 1184520685921370599L;

	@Inject
	private UsuarioService usuarioService;
	
	private List<Usuario> usuarios = new ArrayList<>();
	
	private List<Usuario> usuarioSelecionado = new ArrayList<>();
	
		

	@PostConstruct
	public void inicializar() {
		usuarios = usuarioService.listAll();		
	}
	
	public void excluirSelecionados() {
		for (Usuario usuario : usuarioSelecionado) {
			usuarioService.excluir(usuario);
			usuarios.remove(usuario);
		}
		
		FacesUtil.addInfoMessage("Usuario(s) excluído(s) com sucesso!");
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public List<Usuario> getUsuarioSelecionado() {
		return usuarioSelecionado;
	}

	public void setUsuarioSelecionado(List<Usuario> usuarioSelecionado) {
		this.usuarioSelecionado = usuarioSelecionado;
	}


}

