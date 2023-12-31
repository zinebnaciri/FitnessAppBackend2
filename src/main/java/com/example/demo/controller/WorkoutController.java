package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Workout;
import com.example.demo.service.WorkoutService;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/api/workouts")
@RequiredArgsConstructor
public class WorkoutController {

	private WorkoutService workoutService;

	@GetMapping
	public List<Workout> getAllWorkouts() {
		return workoutService.getAllWorkouts();
	}

	@GetMapping("/{workoutId}")
	public ResponseEntity<Workout> getWorkoutById(@PathVariable Long workoutId) {
		return workoutService.getWorkoutById(workoutId).map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<Workout> createWorkout(@RequestBody Workout workout) {
		Workout savedWorkout = workoutService.saveWorkout(workout);
		return ResponseEntity.ok(savedWorkout);
	}

	@DeleteMapping("/{workoutId}")
	public ResponseEntity<Void> deleteWorkout(@PathVariable Long workoutId) {
		workoutService.deleteWorkout(workoutId);
		return ResponseEntity.noContent().build();
	}

	// Add other endpoints as needed
}
