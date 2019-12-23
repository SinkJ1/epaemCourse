package by.task4.practics.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import by.task4.practics.services.AbstractEnumService;

public abstract class AbstractEnumController<T> {
	
	
	@Autowired
	AbstractEnumService<T> service;
	
	@GetMapping(produces = "application/json;charset=UTF-8")
	public ResponseEntity<List<T>> getAll(){
		return ResponseEntity.ok(service.getAll());
	}
	
}
