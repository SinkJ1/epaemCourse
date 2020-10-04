package by.task4.practics.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import by.task4.practics.entity.Status;

@Controller
@RequestMapping(value = "/status")
public class StatusController extends AbstractEnumController<Status>{

}
