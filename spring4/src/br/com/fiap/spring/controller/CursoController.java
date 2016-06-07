package br.com.fiap.spring.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.fiap.spring.dao.jdbc.JdbcCursoDao;
import br.com.fiap.spring.dao.jdbc.JdbcEscolaDao;
import br.com.fiap.spring.entity.Curso;

@Controller
public class CursoController {
	@RequestMapping("/curso/cadastro")
	public String incluir(ModelMap model) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beanJdbc.xml");
		JdbcEscolaDao daoEscola = (JdbcEscolaDao) ctx.getBean("jdbcEscolaDAO");
		try {
			model.addAttribute("escolas", daoEscola.listarEscolas());
			return "cadastros/incluirCurso";
		} catch (Exception e) {
			model.addAttribute("erro", e.getMessage());
			return "erro";
		}
	}

	@RequestMapping(value = "/cadcurso", method = RequestMethod.POST)
	public String incluir(@RequestParam("idc") int idc, Curso curso, ModelMap model) {
		try {
			ApplicationContext ctx = new ClassPathXmlApplicationContext("beanJdbc.xml");
			JdbcEscolaDao daoEscola = (JdbcEscolaDao) ctx.getBean("jdbcEscolaDAO");
			curso.setEscola(daoEscola.buscarEscola(idc));
			JdbcCursoDao daoCurso = (JdbcCursoDao) ctx.getBean("jdbcCursoDAO");
			daoCurso.incluirCurso(curso);
			model.addAttribute("msg", "Escola " + curso.getDescricao() + "incluída");
			return "cadastros/incluirCurso";
		} catch (Exception e) {
			model.addAttribute("erro", e.getMessage());
			return "erro";
		}
	}
}
