package by.task4.practics.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import by.task4.practics.entity.ApartamentClass;

@Controller
@RequestMapping(value = "apartaments")
public class ApartamentClassController extends AbstractEnumController<ApartamentClass>{

}
