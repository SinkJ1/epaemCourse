package by.task4.practics.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.task4.practics.DAO.UserDao;
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
			if(list.get(0).getPassword().equals(user.getPassword())) {
				return list.get(0);			
			}
		}
		return null;
	}

}
