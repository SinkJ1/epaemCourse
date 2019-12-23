package by.task4.practics.DAO;

import java.util.List;
import javax.persistence.EntityManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Hibernate;

public abstract class AbstractGenericDAO<T> implements GenericDAO<T> {

	protected final Logger log = LogManager.getLogger(getTClass());
	
	public void add(EntityManager em, T object) {
		em.persist(object);
	}

	public void update(EntityManager em, T object) {
		em.merge(object);
	}

	public void delete(EntityManager em, Integer id) {
		em.remove(findById(em, id));
	}

	public T findById(EntityManager em, Integer id) {
		return em.find(getTClass(), id);
	}

	public List<T> getAll(EntityManager em) {
		return em.createQuery("from" + " " + getTClass().getName() + "", getTClass()).getResultList();
	}

	protected abstract Class<T> getTClass();

}
