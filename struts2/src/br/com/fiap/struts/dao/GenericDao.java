package br.com.fiap.struts.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.fiap.struts.entity.Usuario;

public class GenericDao<T> implements Dao<T> {

	private final Class<T> classe;
	protected EntityManager em;

	public GenericDao(Class<T> classe) {
		this.classe = classe;
	}

	@Override
	public void adicionar(T entidade) {
		em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(entidade);
		em.getTransaction().commit();
		em.close();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> listar() {
		em = JpaUtil.getEntityManager();
		return em.createQuery("From " + classe.getSimpleName()).getResultList();
	}

	@Override
	public T buscar(int id) {
		em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		T entidade = em.find(classe, id);
		em.getTransaction().commit();
		em.close();

		return entidade;
	}

	@Override
	public Usuario buscar(String login, String senha) {
		
		em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
			String jpql = "from Usuario usuario where usuario.nome = :pNome and usuario.senha = :pSenha";
			Query query = em.createQuery(jpql);
			query.setParameter("pNome", login);
			query.setParameter("pSenha", senha);
			Usuario usuario = (Usuario)query.getSingleResult();
		em.getTransaction().commit();
		em.close();
	
		return usuario;
	}

}
