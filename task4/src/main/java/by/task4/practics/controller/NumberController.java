package by.task4.practics.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import by.task4.practics.entity.Number;

@Controller
@RequestMapping(value = "/numbers")
public class NumberController extends AbstractController<Number>{

}
