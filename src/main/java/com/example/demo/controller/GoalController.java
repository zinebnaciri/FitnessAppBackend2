package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.web.bind.annotation.*;

import com.example.demo.auth.LoginResponse;
import com.example.demo.entity.Goal;
import com.example.demo.entity.User;
import com.example.demo.repository.GoalRepository;
import com.example.demo.service.GoalService;
import com.example.demo.service.UserService;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/goals")
@RequiredArgsConstructor
@CrossOrigin
public class GoalController {
	@Autowired
	private GoalService goalService;
	@Autowired
	private UserService userService;
	@Autowired
	private GoalRepository goalRepository;

	@GetMapping
	public List<Goal> getAllGoals() {
		return goalService.getAllGoals();
	}

	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Goal>> getAllGoalsByUser(@PathVariable Long userId) {
		try {
			// Retrieve the user by userId
			Optional<User> optionalUser = userService.getUserById(userId);

			if (optionalUser.isEmpty()) {
				return ResponseEntity.notFound().build();
			}

			User user = optionalUser.get();

			// Retrieve goals associated with the user
			List<Goal> goals = goalRepository.findByUser(user);

			return ResponseEntity.ok(goals);
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

	@GetMapping("/{goalId}")
	public ResponseEntity<Goal> getGoalById(@PathVariable Long goalId) {
		try {
			// Retrieve the authenticated user's ID
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			Long userId = ((LoginResponse) authentication.getPrincipal()).getUserId();

			// Check if the goal belongs to the authenticated user
			Optional<Goal> optionalGoal = goalService.getGoalById(goalId, userId);
			return optionalGoal.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

	@PostMapping("/add")
	public ResponseEntity<Goal> createGoal(@RequestBody Goal goal) {

		Goal savedGoal = goalService.saveGoal(goal);
		return ResponseEntity.ok(savedGoal);
	}

	@PutMapping("/update/{goalId}")
	public ResponseEntity<Goal> updateGoalProgress(@PathVariable Long goalId, @RequestBody Goal updatedGoal) {
		try {
			// Retrieve the authenticated user's ID
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			Long userId = ((LoginResponse) authentication.getPrincipal()).getUserId();

			// Check if the goal belongs to the authenticated user
			Optional<Goal> optionalGoal = goalService.getGoalById(goalId, userId);
			if (optionalGoal.isEmpty()) {
				return ResponseEntity.notFound().build();
			}

			Goal existingGoal = optionalGoal.get();

			// Update only the progress field
			existingGoal.setProgress(updatedGoal.getProgress());

			// Save the updated goal
			Goal savedGoal = goalService.saveGoal(existingGoal);

			return ResponseEntity.ok(savedGoal);
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

	@DeleteMapping("/{goalId}")
	public ResponseEntity<Void> deleteGoal(@PathVariable Long goalId) {
		goalService.deleteGoal(goalId);
		return ResponseEntity.noContent().build();
	}

	// Add other endpoints as needed
}
