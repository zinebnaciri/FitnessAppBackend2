package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.WorkoutLog;
import com.example.demo.service.WorkoutLogService;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/api/workout-logs")
@RequiredArgsConstructor
public class WorkoutLogController {

	private WorkoutLogService workoutLogService;

	@GetMapping
	public List<WorkoutLog> getAllWorkoutLogs() {
		return workoutLogService.getAllWorkoutLogs();
	}

	@GetMapping("/{logId}")
	public ResponseEntity<WorkoutLog> getWorkoutLogById(@PathVariable Long logId) {
		return workoutLogService.getWorkoutLogById(logId).map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<WorkoutLog> createWorkoutLog(@RequestBody WorkoutLog workoutLog) {
		WorkoutLog savedWorkoutLog = workoutLogService.saveWorkoutLog(workoutLog);
		return ResponseEntity.ok(savedWorkoutLog);
	}

	@DeleteMapping("/{logId}")
	public ResponseEntity<Void> deleteWorkoutLog(@PathVariable Long logId) {
		workoutLogService.deleteWorkoutLog(logId);
		return ResponseEntity.noContent().build();
	}

	// Add other endpoints as needed
}
