package by.task4.practics.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.task4.practics.DAO.OrderDao;
import by.task4.practics.entity.Order;

@Service
public class OrderServiceImpl extends AbstractService<Order> implements OrderService {

	@Autowired
	private OrderDao orderDao;
	
	@Override
	protected Class<Order> getTClass() {
		return Order.class;
	}
	
	public List<Order> getNotClosedOrders(){
		return orderDao.getNotClosedOrders(entityManager);
	}

}
