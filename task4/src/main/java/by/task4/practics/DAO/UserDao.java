package by.task4.practics.DAO;

import java.util.List;

import javax.persistence.EntityManager;

import by.task4.practics.entity.User;

public interface UserDao extends GenericDAO<User>{

	List<User> findByLogin(EntityManager em, String login);
	
}
