package br.com.crudUpFlitCatalago.mb;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.crudUpFlitCatalago.model.Genero;
import br.com.crudUpFlitCatalago.service.GeneroService;
//controller

@Named
@ViewScoped
public class CadastroGeneroMB implements Serializable{


	private static final long serialVersionUID = 5190925166461008101L;

	

	private Genero genero = new Genero();
	
	private Long idGenero;
	
	@Inject
	private GeneroService generoService;
	
	
	public void inicializar() {
		if (idGenero != null) {
			genero = generoService.porId(idGenero);
		}
	}
	
	
	public String salvar() {
		generoService.salvar(genero);
		return "lista-genero.xhtml?faces-redirect=true";
	}
	
	public String excluir() {
		generoService.excluir(genero);
		return "lista-genero.xhtml?faces-redirect=true";
	}


	public Genero getGenero() {
		return genero;
	}


	public void setGenero(Genero genero) {
		this.genero = genero;
	}


	public Long getIdGenero() {
		return idGenero;
	}


	public void setIdGenero(Long idGenero) {
		this.idGenero = idGenero;
	}

}