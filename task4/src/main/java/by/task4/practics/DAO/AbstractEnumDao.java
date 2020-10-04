package by.task4.practics.DAO;

import java.util.ArrayList;
import java.util.List;


public abstract class AbstractEnumDao<T> {

	List<T> roleList = new ArrayList<>();
	
	protected abstract int getLength();
	
	protected abstract T[] getValues();
	
	private void addInList() {
		roleList.clear();
		for(int i = 0; i < getLength();i++) {
			roleList.add(getValues()[i]);
		}
	}
	
	public List<T> getAll(){
		addInList();
		return roleList;
	}
	
}
