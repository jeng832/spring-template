package org.ijeee.spring.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

	@RequestMapping(value="/health", method=RequestMethod.GET)
	public ResponseEntity<?> health() {
		return ResponseEntity.ok().build();
	}
}
