package by.task4.practics.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import by.task4.practics.entity.Order;
import by.task4.practics.services.OrderService;

@Controller
@RequestMapping(value = "/orders")
public class OrderController extends AbstractController<Order>{

	@Autowired
	private OrderService orderService;
	
	
	@GetMapping(value = "/notClosed", produces = "application/json;charset=UTF-8")
	public ResponseEntity<List<Order>> getNotClosedOrders() {
		return ResponseEntity.ok(orderService.getNotClosedOrders());
	}
	
}
