package by.senla.practics.services;

import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.hibernate.TransactionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import by.senla.practics.interfaces.GenericService;
import by.senla.practics.interfaces.UserDAO;
import by.senla.practics.model.User;

@Service
public class UserService implements GenericService<User> {

	private final Logger log = LogManager.getLogger(UserService.class);

	@Autowired
	private EntityManagerFactory factory;

	@Autowired
	private UserDAO userDAO;
	
	public void persist(User object) {
		EntityManager em = null;
		try {
			em = factory.createEntityManager();
			em.getTransaction().begin();
			userDAO.persist(em, object);
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

	public void update(User object) {
		EntityManager em = null;
		try {
			em = factory.createEntityManager();
			em.getTransaction().begin();
			userDAO.update(em, object);
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

	public void delete(Integer id) {
		EntityManager em = null;
		try {
			em = factory.createEntityManager();
			em.getTransaction().begin();
			userDAO.delete(em, id);
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

	public User findById(Integer id) {
		return userDAO.findById(factory.createEntityManager(), id);
	}

	public List<User> findByFiltr(Map<String, String> map) {
		return userDAO.findByFiltr(map, factory.createEntityManager());
	}
	
	public List<User> getAll() {
		return userDAO.getAll(factory.createEntityManager());
	}

}
