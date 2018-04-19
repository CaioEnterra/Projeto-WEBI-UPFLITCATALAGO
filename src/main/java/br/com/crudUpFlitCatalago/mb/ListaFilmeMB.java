package br.com.crudUpFlitCatalago.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.crudUpFlitCatalago.model.Filme;
import br.com.crudUpFlitCatalago.service.FilmeService;
import br.com.crudUpFlitCatalago.util.FacesUtil;


@Named
@ViewScoped
public class ListaFilmeMB implements Serializable{
	
	
	
	private static final long serialVersionUID = -226449611353443626L;


	@Inject
	private FilmeService filmeService;
	
	private List<Filme> filmes = new ArrayList<>();
	
	private List<Filme> filmeSelecionado = new ArrayList<>();
	
		

	@PostConstruct
	public void inicializar() {
		filmes = filmeService.listAll();		
	}
	
	public void excluirSelecionados() {
		for (Filme filme : filmeSelecionado) {
			filmeService.excluir(filme);
			filmes.remove(filme);
		}
		
		FacesUtil.addInfoMessage("Filme(s) excluído(s) com sucesso!");
	}

	public List<Filme> getFilmes() {
		return filmes;
	}

	public void setFilmes(List<Filme> filmes) {
		this.filmes = filmes;
	}

	public List<Filme> getFilmeSelecionado() {
		return filmeSelecionado;
	}

	public void setFilmeSelecionado(List<Filme> filmeSelecionado) {
		this.filmeSelecionado = filmeSelecionado;
	}




}