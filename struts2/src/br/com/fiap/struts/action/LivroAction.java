package br.com.fiap.struts.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;

import br.com.fiap.struts.dao.GenericDao;
import br.com.fiap.struts.entity.Livro;

@Results({ @Result(name = "ok", location = "/menu.jsp"), @Result(name = "erro", location = "/erro.jsp"),
		@Result(name = "input", location = "/cadLivros.jsp"), @Result(name = "lista", location = "/listaLivros.jsp") })
public class LivroAction extends ActionSupport {

	private static final long serialVersionUID = -8723155179429687822L;

	private File figura;
	private Livro livro;
	private List<Livro> listaLivros;

	public File getFigura() {
		return figura;
	}

	public void setFigura(File figura) {
		this.figura = figura;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public List<Livro> getListaLivros() {
		return listaLivros;
	}

	public void setListaLivros(List<Livro> listaLivros) {
		this.listaLivros = listaLivros;
	}

	public LivroAction() {
		livro = new Livro();
		listaLivros = new ArrayList<>();
	}

	@Action(value = "/cadastro")
	public String incluir() {
		try {
			InputStream inputStream = new FileInputStream(figura);
			byte[] imagem = new byte[(int) figura.length()];
			inputStream.read(imagem, 0, (int) figura.length());
			livro.setImagem(imagem);
			GenericDao<Livro> dao = new GenericDao<Livro>(Livro.class);
			dao.adicionar(livro);
			return "ok";
		} catch (Exception e) {
			return "erro";
		}
	}

	@Action(value = "/consulta")
	public String listar() {
		GenericDao<Livro> dao = new GenericDao<Livro>(Livro.class);
		listaLivros = dao.listar();
		return "lista";
	}

}