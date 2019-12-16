package by.senla.practics.connectionUtil;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class EntityManagerUtil {

	private static EntityManagerFactory emf = null;

	public static EntityManager getEm() {
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory("persistence");
		}
		return emf.createEntityManager();
	}

}
