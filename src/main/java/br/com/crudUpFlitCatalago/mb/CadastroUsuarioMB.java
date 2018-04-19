package br.com.crudUpFlitCatalago.mb;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.crudUpFlitCatalago.model.Usuario;
import br.com.crudUpFlitCatalago.service.UsuarioService;


@Named
@ViewScoped
public class CadastroUsuarioMB implements Serializable{

	
	private static final long serialVersionUID = -4338031755744066347L;



	private Usuario usuario = new Usuario();
	
	private Long idUsuario;
	
	@Inject
	private UsuarioService usuarioService;
	
	
	public void inicializar() {
		if (idUsuario != null) {
			usuario = usuarioService.porId(idUsuario);
		}
	}
	
	
	public String salvar() {
		usuarioService.salvar(usuario);
		return "lista-usuario.xhtml?faces-redirect=true";
	}
	
	public String excluir() {
		usuarioService.excluir(usuario);
		return "lista-usuario.xhtml?faces-redirect=true";
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public Long getIdUsuario() {
		return idUsuario;
	}


	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

}