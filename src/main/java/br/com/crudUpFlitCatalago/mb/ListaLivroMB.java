package br.com.crudUpFlitCatalago.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.crudUpFlitCatalago.model.Livro;
import br.com.crudUpFlitCatalago.service.LivroService;
import br.com.crudUpFlitCatalago.util.FacesUtil;


@Named
@ViewScoped
public class ListaLivroMB implements Serializable{
	
	

	private static final long serialVersionUID = -4357864423202421732L;


	@Inject
	private LivroService livroService;
	
	private List<Livro> livros = new ArrayList<>();
	
	private List<Livro> livroSelecionado = new ArrayList<>();
	
		

	@PostConstruct
	public void inicializar() {
		livros = livroService.listAll();		
	}
	
	public void excluirSelecionados() {
		for (Livro livro : livroSelecionado) {
			livroService.excluir(livro);
			livros.remove(livro);
		}
		
		FacesUtil.addInfoMessage("Livro(s) excluído(s) com sucesso!");
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	public List<Livro> getLivroSelecionado() {
		return livroSelecionado;
	}

	public void setLivroSelecionado(List<Livro> livroSelecionado) {
		this.livroSelecionado = livroSelecionado;
	}




}