package by.task4.practics.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import by.task4.practics.DAO.AbstractEnumDao;

public abstract class AbstractEnumService<T> {

	
	@Autowired
	AbstractEnumDao<T> dao;
	
	public List<T> getAll(){
		return dao.getAll();
	}
	
}
