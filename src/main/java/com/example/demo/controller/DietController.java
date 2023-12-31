package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Diet;
import com.example.demo.service.DietService;

import java.util.List;

@RestController
@RequestMapping("/api/diets")
public class DietController {

	private DietService dietService;

	public DietController(DietService dietService) {
		this.dietService = dietService;
	}

	@GetMapping
	public List<Diet> getAllDiets() {
		return dietService.getAllDiets();
	}

	@GetMapping("/{dietId}")
	public ResponseEntity<Diet> getDietById(@PathVariable Long dietId) {
		return dietService.getDietById(dietId).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<Diet> createDiet(@RequestBody Diet diet) {
		Diet savedDiet = dietService.saveDiet(diet);
		return ResponseEntity.ok(savedDiet);
	}

	@DeleteMapping("/{dietId}")
	public ResponseEntity<Void> deleteDiet(@PathVariable Long dietId) {
		dietService.deleteDiet(dietId);
		return ResponseEntity.noContent().build();
	}

}
