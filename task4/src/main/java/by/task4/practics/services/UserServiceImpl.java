package by.task4.practics.services;

import java.util.List;

import org.hibernate.TransactionException;
import org.postgresql.util.PSQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.task4.practics.DAO.UserDao;
import by.task4.practics.entity.Role;
import by.task4.practics.entity.User;

@Service
public class UserServiceImpl extends AbstractService<User> implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	protected Class<User> getTClass() {
		return User.class;
	}
	
	
	public User findByLogin(User user) {
		List<User> list = userDao.findByLogin(entityManager, user.getLogin());
		if(!list.isEmpty()) {
			if(String.valueOf(user.getPassword().hashCode()).equals(list.get(0).getPassword())) {
				return list.get(0);			
			}
		}
		return null;
	}
	
	@Override
	@Transactional
	public User add(User user) {
		user.setPassword(String.valueOf(user.getPassword().hashCode()));
		user.setRole(Role.USER);
		try {
			userDao.add(entityManager, user);
			return user;
		} catch(TransactionException te) {
			log.warn(te);
		}
		return null;
	}

}
