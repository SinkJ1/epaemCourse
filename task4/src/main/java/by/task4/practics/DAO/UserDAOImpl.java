package by.task4.practics.DAO;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import by.task4.practics.entity.User;
import by.task4.practics.interfaces.UserDAO;

@Repository
public class UserDAOImpl extends AbstractGenericDAO<User> implements UserDAO {


	protected Class<User> getTClass() {
		return User.class;

	}


}
