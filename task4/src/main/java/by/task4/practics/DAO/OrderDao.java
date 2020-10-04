package by.task4.practics.DAO;

import java.util.List;

import javax.persistence.EntityManager;

import by.task4.practics.entity.Order;

public interface OrderDao extends GenericDAO<Order>{

	List<Order> getNotClosedOrders(EntityManager em);
	
}
