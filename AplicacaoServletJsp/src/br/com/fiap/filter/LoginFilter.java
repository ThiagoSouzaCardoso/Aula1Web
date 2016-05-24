package br.com.fiap.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.fiap.entity.Usuario;

@WebFilter(urlPatterns="/admin/*")
public class LoginFilter implements Filter {

    public LoginFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpSession session = ((HttpServletRequest) request).getSession();
		Usuario usuario = (Usuario)session.getAttribute("usuario_sessao");
		
		if(usuario != null)
			chain.doFilter(request, response);

		session.getServletContext().getRequestDispatcher("/valida").forward(request, response);
	
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
