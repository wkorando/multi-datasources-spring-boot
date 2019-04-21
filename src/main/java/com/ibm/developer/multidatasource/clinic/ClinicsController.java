package com.ibm.developer.multidatasource.clinic;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clinics")
public class ClinicsController {
	private ClinicsRepo repo;

	ClinicsController(ClinicsRepo repo) {
		this.repo = repo;
	}

	@GetMapping
	public ResponseEntity<Iterable<Clinic>> findAll() {
		return ResponseEntity.ok(repo.findAll());
	}

	@PostMapping
	public ResponseEntity<?> add(@RequestBody Clinic doctor) {
		return ResponseEntity.created(URI.create("/doctors/" + repo.save(doctor).getId())).build();
	}
}
