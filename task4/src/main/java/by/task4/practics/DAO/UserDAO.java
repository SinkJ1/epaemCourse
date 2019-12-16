package by.senla.practics.DAO;

import org.springframework.stereotype.Repository;
import by.senla.practics.interfaces.GenericDAO;
import by.senla.practics.model.User;

@Repository
public class UserDAO extends AbstractGenericDAO<User> implements GenericDAO<User> {

	private static UserDAO instance;

	private UserDAO() {
	}

	protected Class<User> getTClass() {
		return User.class;

	}

	public static UserDAO getInstance() {
		if (instance == null) {
			instance = new UserDAO();
			return instance;
		}
		return instance;
	}

}
