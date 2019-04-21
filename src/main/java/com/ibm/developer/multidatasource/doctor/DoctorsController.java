package com.ibm.developer.multidatasource.doctor;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctors")
public class DoctorsController {
	private DoctorsRepo repo;

	
	
	DoctorsController(DoctorsRepo repo) {
		this.repo = repo;
	}

	@GetMapping
	public ResponseEntity<Iterable<Doctor>> findAll() {
		return ResponseEntity.ok(repo.findAll());
	}

	@PostMapping
	public ResponseEntity<?> add(@RequestBody Doctor doctor) {
		return ResponseEntity.created(URI.create("/doctors/" + repo.save(doctor).getId())).build();
	}
}
