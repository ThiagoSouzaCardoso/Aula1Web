package br.com.fiap.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.dao.GenericDao;
import br.com.fiap.entity.Livro;

@WebServlet("/admin/consultarLivro")
public class ServletConsultarLivro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletConsultarLivro() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		GenericDao<Livro> dao = new GenericDao<>(Livro.class);
		int id = Integer.parseInt(request.getParameter("codigo"));
		Livro livro = dao.buscar(id);
		
		request.setAttribute("livro", livro);
		request.getRequestDispatcher("mostrarLivro.jsp")
				.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
