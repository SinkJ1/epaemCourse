package by.task4.practics.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import by.task4.practics.entity.User;

@Controller
@RequestMapping(value = "/users")
public class UserController extends AbstractController<User>{



}
