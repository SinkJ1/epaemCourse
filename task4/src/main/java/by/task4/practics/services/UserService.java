package by.task4.practics.services;

import by.task4.practics.entity.User;

public interface UserService extends GenericService<User>{

	User findByLogin(User user);
	
}
