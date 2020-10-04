package by.task4.practics.DAO;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import by.task4.practics.entity.Order;

@Repository
public class OrderDaoImpl extends AbstractGenericDAO<Order> implements OrderDao {

	@Override
	protected Class<Order> getTClass() {
		return Order.class;
	}

	@Override
	public List<Order> getNotClosedOrders(EntityManager em) {
		return em.createQuery("from " + getTClass().getName() + " t where status != '1'", getTClass()).getResultList();
	}

}
