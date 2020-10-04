package by.task4.practics.services;

import java.util.List;

import by.task4.practics.entity.Order;

public interface OrderService extends GenericService<Order>{

	List<Order> getNotClosedOrders();
}
