package by.task4.practics.DAO;


import org.springframework.stereotype.Repository;

import by.task4.practics.entity.User;

@Repository
public class UserDAOImpl extends AbstractGenericDAO<User> implements GenericDAO<User> {


	protected Class<User> getTClass() {
		return User.class;

	}


}
