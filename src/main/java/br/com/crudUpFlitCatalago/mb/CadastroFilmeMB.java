package br.com.crudUpFlitCatalago.mb;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.crudUpFlitCatalago.model.Filme;
import br.com.crudUpFlitCatalago.service.FilmeService;



@Named
@ViewScoped
public class CadastroFilmeMB implements Serializable{



	private static final long serialVersionUID = 2187429124709269704L;


	private Filme filme = new Filme();
	
	private Long idFilme;
	
	@Inject
	private FilmeService filmeService;
	
	
	public void inicializar() {
		if (idFilme != null) {
			filme = filmeService.porId(idFilme);
		}
	}
	
	
	public String salvar() {
		filmeService.salvar(filme);
		return "lista-filme.xhtml?faces-redirect=true";
	}
	
	public String excluir() {
		filmeService.excluir(filme);
		return "lista-filme.xhtml?faces-redirect=true";
	}


	public Filme getFilme() {
		return filme;
	}


	public void setFilme(Filme filme) {
		this.filme = filme;
	}


	public Long getIdFilme() {
		return idFilme;
	}


	public void setIdFilme(Long idFilme) {
		this.idFilme = idFilme;
	}

}
