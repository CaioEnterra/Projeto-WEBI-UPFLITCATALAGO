package br.com.crudUpFlitCatalago.mb;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.crudUpFlitCatalago.model.Livro;
import br.com.crudUpFlitCatalago.service.LivroService;


@Named
@ViewScoped
public class CadastroLivroMB implements Serializable{

	private static final long serialVersionUID = -9195659332984877766L;



	private Livro livro = new Livro();
	
	private Long idLivro;
	
	@Inject
	private LivroService livroService;
	
	
	public void inicializar() {
		if (idLivro != null) {
			livro = livroService.porId(idLivro);
		}
	}
	
	
	public String salvar() {
		livroService.salvar(livro);
		return "lista-livro.xhtml?faces-redirect=true";
	}
	
	public String excluir() {
		livroService.excluir(livro);
		return "lista-livro.xhtml?faces-redirect=true";
	}


	public Livro getLivro() {
		return livro;
	}


	public void setLivro(Livro livro) {
		this.livro = livro;
	}


	public Long getIdLivro() {
		return idLivro;
	}


	public void setIdLivro(Long idLivro) {
		this.idLivro = idLivro;
	}

}
