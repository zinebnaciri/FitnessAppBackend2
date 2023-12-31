package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.FollowedWorkout;
import com.example.demo.service.FollowedWorkoutService;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/api/followed-workouts")
@RequiredArgsConstructor
public class FollowedWorkoutController {

	private FollowedWorkoutService followedWorkoutService;

	@GetMapping
	public List<FollowedWorkout> getAllFollowedWorkouts() {
		return followedWorkoutService.getAllFollowedWorkouts();
	}

	@GetMapping("/{followId}")
	public ResponseEntity<FollowedWorkout> getFollowedWorkoutById(@PathVariable Long followId) {
		return followedWorkoutService.getFollowedWorkoutById(followId).map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<FollowedWorkout> createFollowedWorkout(@RequestBody FollowedWorkout followedWorkout) {
		FollowedWorkout savedFollowedWorkout = followedWorkoutService.saveFollowedWorkout(followedWorkout);
		return ResponseEntity.ok(savedFollowedWorkout);
	}

	@DeleteMapping("/{followId}")
	public ResponseEntity<Void> deleteFollowedWorkout(@PathVariable Long followId) {
		followedWorkoutService.deleteFollowedWorkout(followId);
		return ResponseEntity.noContent().build();
	}

	// Add other endpoints as needed
}
