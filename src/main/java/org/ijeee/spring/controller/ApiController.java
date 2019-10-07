package org.ijeee.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

	private List<Integer> value = new ArrayList<Integer> ();
	@RequestMapping(value="/health", method=RequestMethod.GET)
	public ResponseEntity<?> health() {
		return ResponseEntity.ok().build();
	}
	
	@RequestMapping(value="/value/index/{index}", method=RequestMethod.GET)
	public ResponseEntity<Integer> getValue(@PathVariable Integer index) {
		return new ResponseEntity<Integer>(value.get(index), HttpStatus.OK);
	}
	
	@RequestMapping(value="/value/elem/{element}", method=RequestMethod.PUT)
	public ResponseEntity<?> postValue(@PathVariable Integer element) {
		this.value.add(element);
		return ResponseEntity.ok().build();
	}
	
	@RequestMapping(value="/value/index/{index}/elem/{element}", method=RequestMethod.POST)
	public ResponseEntity<?> postValue(@PathVariable Integer index, @PathVariable Integer element) {
		this.value.add(index, element);
		return ResponseEntity.ok().build();
	}
	
	@RequestMapping(value="/value/index/{index}", method=RequestMethod.DELETE)
	public ResponseEntity<?> deleteValue(@PathVariable int index) {
		this.value.remove(index);
		
		return ResponseEntity.ok().build();
	}
}
