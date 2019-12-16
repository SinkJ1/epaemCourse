package by.task4.practics.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.TransactionException;
import org.springframework.beans.factory.annotation.Autowired;

import by.task4.practics.DAO.GenericDAO;

public abstract class AbstractService<T> implements GenericService<T> {

	
	private final Logger log = LogManager.getLogger(UserService.class);

	@Autowired
	private EntityManagerFactory factory;

	@Autowired
	private GenericDAO<T> dao;
	
	@Override
	public void add(T object) {
		EntityManager em = null;
		try {
			em = factory.createEntityManager();
			em.getTransaction().begin();
			dao.add(em, object);
			em.getTransaction().commit();
		} catch (TransactionException te) {
			em.getTransaction().rollback();
			log.error(te);
			throw new RuntimeException(te);
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	@Override
	public void update(T object) {
		EntityManager em = null;
		try {
			em = factory.createEntityManager();
			em.getTransaction().begin();
			dao.update(em, object);
			em.getTransaction().commit();
		} catch (TransactionException te) {
			em.getTransaction().rollback();
			log.error(te);
			throw new RuntimeException(te);
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	@Override
	public void delete(Integer id) {
		EntityManager em = null;
		try {
			em = factory.createEntityManager();
			em.getTransaction().begin();
			dao.delete(em, id);
			em.getTransaction().commit();
		} catch (TransactionException te) {
			em.getTransaction().rollback();
			log.error(te);
			throw new RuntimeException(te);
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	@Override
	public T findById(Integer id) {
		return dao.findById(factory.createEntityManager(), id);
	}

	@Override
	public List<T> getAll() {
		return dao.getAll(factory.createEntityManager());
	}

}
