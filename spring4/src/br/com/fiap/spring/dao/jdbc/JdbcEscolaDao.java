package br.com.fiap.spring.dao.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import br.com.fiap.spring.entity.Escola;

public class JdbcEscolaDao {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void incluirEscola(Escola escola) throws Exception {
		try {
			String query = "INSERT INTO ESCOLA (DESCRICAO,ENDERECO,DATAFUNDACAO) VALUES (?,?,?)";
			jdbcTemplate.update(query, escola.getDescricao(), escola.getEndereco(), escola.getDataFundacao());
		} catch (Exception e) {
			throw e;
		}
	}

	public Escola buscarEscola(int id) throws Exception {
		Escola escola = null;
		try {
			String query = "SELECT * FROM ESCOLA WHERE ID=?";
			escola = jdbcTemplate.queryForObject(query, new Integer[] { id }, new EscolaMapper());
		} catch (Exception e) {
			throw e;
		}
		return escola;
	}

	public List<Escola> listarEscolas() throws Exception {
		List<Escola> escolas = new ArrayList<>();
		try {
			escolas = jdbcTemplate.query("SELECT * FROM ESCOLA", new EscolaMapper());
		} catch (Exception e) {
			throw e;
		}
		return escolas;
	}
}