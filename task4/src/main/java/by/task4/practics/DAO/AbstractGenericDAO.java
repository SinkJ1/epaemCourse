package by.senla.practics.DAO;

import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import by.senla.practics.interfaces.GenericDAO;

public abstract class AbstractGenericDAO<T> implements GenericDAO<T> {

	public void persist(EntityManager em, T object) {
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

	public List<T> findByFiltr(Map<String, String> map, EntityManager em) {
		Integer i = 0;
		String whereValue = "";
		for (Map.Entry<String, String> item : map.entrySet()) {
			if (i >= 1) {
				whereValue = whereValue + " and t." + item.getKey() + " = " + "'" + item.getValue() + "'";
			} else {
				whereValue = whereValue + " t." + item.getKey() + " = " + "'" + item.getValue() + "'";
			}
			i += 1;
		}
		return em.createQuery("from " + getTClass().getName() + " t where " + whereValue + "", getTClass())
				.getResultList();
	}

	protected abstract Class<T> getTClass();

}
