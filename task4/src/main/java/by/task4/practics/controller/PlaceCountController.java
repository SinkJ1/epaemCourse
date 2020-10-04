package by.task4.practics.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import by.task4.practics.entity.PlaceCount;

@Controller
@RequestMapping(value = "places")
public class PlaceCountController extends AbstractEnumController<PlaceCount>{
}
