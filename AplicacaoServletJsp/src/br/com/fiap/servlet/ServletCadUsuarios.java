package br.com.fiap.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.dao.GenericDao;
import br.com.fiap.entity.Usuario;

@WebServlet("/admin/cadusuarios")
public class ServletCadUsuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletCadUsuarios() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String nome = request.getParameter("nome");
			String senha = request.getParameter("senha");
			int nivel = Integer.parseInt(request.getParameter("nivel"));
			
			Usuario usuario = new Usuario();
			usuario.setNome(nome);
			usuario.setSenha(senha);
			usuario.setNivel(nivel);		

			GenericDao<Usuario> dao = 
					new GenericDao<Usuario>(Usuario.class);
			dao.adicionar(usuario);
			
			request.setAttribute("msg", "Usuário " + 
			            usuario.getId() + " incluído");
		} catch (Exception e) {
			request.setAttribute("msg", e.getMessage());
		}
		finally {
			request.getRequestDispatcher("cadUsuarios.jsp").forward(request, response);			
		}
	}
}
