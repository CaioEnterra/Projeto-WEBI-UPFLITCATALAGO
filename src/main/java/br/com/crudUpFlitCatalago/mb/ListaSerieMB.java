package br.com.crudUpFlitCatalago.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.crudUpFlitCatalago.model.Serie;
import br.com.crudUpFlitCatalago.service.SerieService;
import br.com.crudUpFlitCatalago.util.FacesUtil;


@Named
@ViewScoped
public class ListaSerieMB implements Serializable{
	

	private static final long serialVersionUID = -7631890951418073565L;

	@Inject
	private SerieService serieService;
	
	private List<Serie> series = new ArrayList<>();
	
	private List<Serie> serieSelecionado = new ArrayList<>();
	
		

	@PostConstruct
	public void inicializar() {
		series = serieService.listAll();		
	}
	
	public void excluirSelecionados() {
		for (Serie serie : serieSelecionado) {
			serieService.excluir(serie);
			series.remove(serie);
		}
		
		FacesUtil.addInfoMessage("Serie(s) excluído(s) com sucesso!");
	}

	public List<Serie> getSeries() {
		return series;
	}

	public void setSeries(List<Serie> series) {
		this.series = series;
	}

	public List<Serie> getSerieSelecionado() {
		return serieSelecionado;
	}

	public void setSerieSelecionado(List<Serie> serieSelecionado) {
		this.serieSelecionado = serieSelecionado;
	}




}