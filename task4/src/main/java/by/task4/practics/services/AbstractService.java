package by.task4.practics.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import by.task4.practics.DAO.GenericDAO;

public abstract class AbstractService<T> implements GenericService<T> {

	private final Logger log = LogManager.getLogger(getTClass());
	
	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private GenericDAO<T> dao;

	@Transactional
	public void add(T object) {
		dao.add(entityManager, object);
	}
	
	@Transactional
	public void delete(Integer id) {
		dao.delete(entityManager, id);
	}
	
	@Transactional
	public void update(T object) {
		dao.update(entityManager, object);
	}
	
	public T findById(Integer id) {
		return dao.findById(entityManager, id);
	}

	public List<T> getAll() {
		return dao.getAll(entityManager);
	}
	
	protected abstract Class<T> getTClass();

}
