package by.task4.practics.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import by.task4.practics.services.GenericService;


public abstract class AbstractController<T> {

	@Autowired
	protected GenericService<T> genericService;

	@PostMapping(produces = "application/json;charset=UTF-8")
	public ResponseEntity<T> add(@RequestBody T entity) {
		genericService.add(entity);
		return ResponseEntity.ok().build();
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<T> getOne(@PathVariable("id") int id){
		return ResponseEntity.ok(genericService.findById(id));
		
	}
	
	@GetMapping(produces = "application/json;charset=UTF-8")
	public ResponseEntity<List<T>> getAll() {
		return ResponseEntity.ok(genericService.getAll());
	}



}
