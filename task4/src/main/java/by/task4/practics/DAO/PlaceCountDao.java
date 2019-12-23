package by.task4.practics.DAO;

import org.springframework.stereotype.Repository;

import by.task4.practics.entity.PlaceCount;

@Repository
public class PlaceCountDao extends AbstractEnumDao<PlaceCount>{

	@Override
	protected int getLength() {
		return PlaceCount.values().length;
	}

	@Override
	protected PlaceCount[] getValues() {
		return PlaceCount.values();
	}

}
