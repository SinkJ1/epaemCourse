package by.senla.practics.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import by.senla.practics.interfaces.GenericService;
import by.senla.practics.model.User;
import javassist.expr.NewArray;

public abstract class AbstractController<T> {

	@Autowired
	private GenericService<T> genericService;


	@PostMapping(produces = "application/json;charset=UTF-8")
	public ResponseEntity<T> add(@RequestBody T entity) {
		genericService.persist(entity);
		return ResponseEntity.ok().build();
	}

	@GetMapping(produces = "application/json;charset=UTF-8")
	public ResponseEntity<List<T>> getAll() {
		return ResponseEntity.ok(genericService.getAll());
	}



}
