package br.com.crudUpFlitCatalago.mb;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.crudUpFlitCatalago.conexao.conexao;
import br.com.crudUpFlitCatalago.model.Usuario;
import br.com.crudUpFlitCatalago.service.UsuarioService;


@Named
@ViewScoped
public class CadastroUsuarioMB implements Serializable{

	
	private static final long serialVersionUID = -4338031755744066347L;


	private Connection conn;
	private List<Usuario> usuarios = new ArrayList<Usuario>();
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

	
	public String logar() throws SQLException {
		this.conn = conexao.getConexao();
		Statement st = this.conn.createStatement();
		String sql = "SELECT * FROM usuario WHERE cpf = '"
				+ usuario.getCpf() + "'";
		ResultSet rs = st.executeQuery(sql);
		if (rs.next()) {
			Usuario temp = new Usuario();

			//temp.getIdusuario();
			//temp.getNome_usuario();
			temp.getCpf();

			usuarios.add(temp);

			FacesMessage msg = new FacesMessage("SEJA BEM VINDO" +" " + usuario.getNome_usuario());
			FacesContext.getCurrentInstance().addMessage("Success: ", msg);

			return "index.xhtml";
		} else {
			FacesMessage msg = new FacesMessage("Usuário ou senha Invalidos!");
			FacesContext.getCurrentInstance().addMessage("Erro: ", msg); 
			//this.Mensagem = "Usuário ou senha inválidos!";
		}
		return "login.xhtml";
	}
	
}