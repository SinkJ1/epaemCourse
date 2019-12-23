package by.task4.practics.DAO;

import org.springframework.stereotype.Repository;

import by.task4.practics.entity.ApartamentClass;

@Repository
public class ApartamentClassDaoImpl extends AbstractEnumDao<ApartamentClass> {

	@Override
	protected int getLength() {
		return ApartamentClass.values().length;
	}

	@Override
	protected ApartamentClass[] getValues() {
		return ApartamentClass.values();
	}

}
