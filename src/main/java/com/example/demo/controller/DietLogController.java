package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.DietLog;
import com.example.demo.service.DietLogService;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/api/diet-logs")
@RequiredArgsConstructor
public class DietLogController {

	private DietLogService dietLogService;

	@GetMapping
	public List<DietLog> getAllDietLogs() {
		return dietLogService.getAllDietLogs();
	}

	@GetMapping("/{logId}")
	public ResponseEntity<DietLog> getDietLogById(@PathVariable Long logId) {
		return dietLogService.getDietLogById(logId).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<DietLog> createDietLog(@RequestBody DietLog dietLog) {
		DietLog savedDietLog = dietLogService.saveDietLog(dietLog);
		return ResponseEntity.ok(savedDietLog);
	}

	@DeleteMapping("/{logId}")
	public ResponseEntity<Void> deleteDietLog(@PathVariable Long logId) {
		dietLogService.deleteDietLog(logId);
		return ResponseEntity.noContent().build();
	}

	// Add other endpoints as needed
}
