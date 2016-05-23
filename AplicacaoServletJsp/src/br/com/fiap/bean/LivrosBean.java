package br.com.fiap.bean;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.dao.GenericDao;
import br.com.fiap.entity.Livro;

public class LivrosBean {

	public List<Livro> getListaLivros(){
		List<Livro> livros = new ArrayList<>();
		
		GenericDao<Livro> dao = new GenericDao<>(Livro.class);
		livros = dao.listar();
		
		return livros;
	}
	
	
}
