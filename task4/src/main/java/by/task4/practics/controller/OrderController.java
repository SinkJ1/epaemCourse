package by.task4.practics.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import by.task4.practics.entity.Order;

@Controller
@RequestMapping(value = "/order")
public class OrderController extends AbstractController<Order>{

}
