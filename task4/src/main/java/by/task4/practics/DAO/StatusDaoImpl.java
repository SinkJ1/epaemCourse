package by.task4.practics.DAO;

import org.springframework.stereotype.Repository;

import by.task4.practics.entity.Status;

@Repository
public class StatusDaoImpl extends AbstractEnumDao<Status>{

	@Override
	protected int getLength() {
		return Status.values().length;
	}

	@Override
	protected Status[] getValues() {
		return Status.values();
	}

}
