package br.com.crudUpFlitCatalago.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.crudUpFlitCatalago.model.Genero;
import br.com.crudUpFlitCatalago.service.GeneroService;
import br.com.crudUpFlitCatalago.util.FacesUtil;
//controller



@Named
@ViewScoped
public class ListaGeneroMB implements Serializable{
	

	private static final long serialVersionUID = -7467901998795186648L;

	@Inject
	private GeneroService generoService;
	
	private List<Genero> generos = new ArrayList<>();
	
	private List<Genero> generoSelecionado = new ArrayList<>();
	
		

	@PostConstruct
	public void inicializar() {
		generos = generoService.listAll();		
	}
	
	public void excluirSelecionados() {
		for (Genero genero : generoSelecionado) {
			generoService.excluir(genero);
			generos.remove(genero);
		}
		
		FacesUtil.addInfoMessage("Genero(s) excluído(s) com sucesso!");
	}

	public List<Genero> getGeneros() {
		return generos;
	}

	public void setGeneros(List<Genero> generos) {
		this.generos = generos;
	}

	public List<Genero> getGeneroSelecionado() {
		return generoSelecionado;
	}

	public void setGeneroSelecionado(List<Genero> generoSelecionado) {
		this.generoSelecionado = generoSelecionado;
	}




}