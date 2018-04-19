package br.com.crudUpFlitCatalago.mb;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.crudUpFlitCatalago.model.Serie;
import br.com.crudUpFlitCatalago.service.SerieService;



@Named
@ViewScoped
public class CadastroSerieMB implements Serializable{


	private static final long serialVersionUID = 2843039840502329280L;


	private Serie serie = new Serie();
	
	private Long idSerie;
	
	@Inject
	private SerieService serieService;
	
	
	public void inicializar() {
		if (idSerie != null) {
			serie = serieService.porId(idSerie);
		}
	}
	
	
	public String salvar() {
		serieService.salvar(serie);
		return "lista-serie.xhtml?faces-redirect=true";
	}
	
	public String excluir() {
		serieService.excluir(serie);
		return "lista-serie.xhtml?faces-redirect=true";
	}


	public Serie getSerie() {
		return serie;
	}


	public void setSerie(Serie serie) {
		this.serie = serie;
	}


	public Long getIdSerie() {
		return idSerie;
	}


	public void setIdSerie(Long idSerie) {
		this.idSerie = idSerie;
	}

}
