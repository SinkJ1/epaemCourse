package by.task4.practics.DAO;

import org.springframework.stereotype.Repository;

import by.task4.practics.entity.Role;

@Repository
public class RoleDaoImpl extends AbstractEnumDao<Role> {

	@Override
	protected int getLength() {
		return Role.values().length;
	}

	@Override
	protected Role[] getValues() {
		return Role.values();
	}


}
