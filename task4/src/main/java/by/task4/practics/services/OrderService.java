package by.task4.practics.services;

import org.springframework.stereotype.Service;

import by.task4.practics.entity.Order;

@Service
public class OrderService extends AbstractService<Order> implements GenericService<Order> {

	@Override
	protected Class<Order> getTClass() {
		return Order.class;
	}

}
