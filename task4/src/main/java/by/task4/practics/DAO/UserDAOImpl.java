package by.task4.practics.DAO;


import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import by.task4.practics.entity.User;

@Repository
public class UserDAOImpl extends AbstractGenericDAO<User> implements UserDao{


	protected Class<User> getTClass() {
		return User.class;

	}

	@Override
	public List<User> findByLogin(EntityManager em, String login) {
		return em.createQuery("from " + getTClass().getName() + " t where t.login = " + "'" + login + "'" + "", getTClass()).getResultList();
	}


}
