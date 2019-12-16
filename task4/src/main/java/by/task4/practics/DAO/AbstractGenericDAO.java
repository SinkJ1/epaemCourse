package by.task4.practics.DAO;

import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import by.task4.practics.interfaces.GenericDAO;

public abstract class AbstractGenericDAO<T> implements GenericDAO<T> {

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
