package br.com.fiap.spring.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.fiap.spring.dao.jdbc.JdbcEscolaDao;
import br.com.fiap.spring.entity.Escola;

@Controller
public class EscolaController {
	@RequestMapping("/escola/cadastro")
	public String incluir() {
		return "cadastros/incluirEscola";
	}

	@RequestMapping(value = "/cadescola", method = RequestMethod.POST)
	public String incluir(Escola escola, ModelMap model) {
		try {
			ApplicationContext ctx = new ClassPathXmlApplicationContext("beanJdbc.xml");
			JdbcEscolaDao dao = (JdbcEscolaDao) ctx.getBean("jdbcEscolaDAO");
			dao.incluirEscola(escola);
			model.addAttribute("msg", "Escola " + escola.getDescricao() + "incluída");
			return "cadastros/incluirEscola";
		} catch (Exception e) {
			System.out.println(e.getMessage());
			model.addAttribute("erro", e.getMessage());
			return "erro";
		}
	}
}
