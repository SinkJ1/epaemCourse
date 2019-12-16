package by.task4.practics.DAO;

import org.springframework.stereotype.Repository;

import by.task4.practics.entity.Number;

@Repository
public class NumberDaoImpl extends AbstractGenericDAO<Number> implements GenericDAO<Number> {

	@Override
	protected Class<Number> getTClass() {
		return Number.class;
	}

}
