package br.com.fiap.struts.dao;


import java.util.List;

import br.com.fiap.struts.entity.Usuario;

public interface Dao<T> {
	void adicionar(T entidade);
	 List<T> listar();
	 T buscar(int id);
	Usuario buscar(String string, String senha); 
}
