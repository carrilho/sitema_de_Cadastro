package br.com.estudos.model.daoImpl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;

import br.com.estudos.model.dao.CadastroDAO;

public class CadastroDAOImpl<T> implements CadastroDAO<T>, Serializable{
	
	private static final long serialVersionUID = 1L;
		
	private Class<T> classe;
	
	private Session session;
	
	public CadastroDAOImpl(Class<T> classe, Session session) {
		super();
		this.classe = classe;
		this.session = session;
	}

	@Override
	public void save(T entity) {
		session.save(entity);
	}

	@Override
	public void update(T entity) {
		session.update(entity);
	}

	@Override
	public void remove(T entity) {
		session.delete(entity);
	}

	@Override
	public T getEntity(Serializable id) {
		
		T entity = (T) session.get(classe, id);
		
		return entity;
	}

	@Override
	public T getEntityByDetachedCriteria(DetachedCriteria criteria) {
		
		T entity = (T) criteria.getExecutableCriteria(session).uniqueResult();
		
		return entity;
	}

	@Override
	public List<T> getEntities() {
		
		List<T> entities = (List<T>) session.createCriteria(classe).list();
		
		return entities;
	}

	@Override
	public List<T> getListByDetachedCriteria(DetachedCriteria criteria) {
		return criteria.getExecutableCriteria(session).list();
	}

}
