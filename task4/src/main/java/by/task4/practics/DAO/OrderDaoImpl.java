package by.task4.practics.DAO;

import org.springframework.stereotype.Repository;

import by.task4.practics.entity.Order;

@Repository
public class OrderDaoImpl extends AbstractGenericDAO<Order> implements GenericDAO<Order> {

	@Override
	protected Class<Order> getTClass() {
		return Order.class;
	}

}
