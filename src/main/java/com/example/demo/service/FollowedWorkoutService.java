package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.FollowedWorkout;
import com.example.demo.repository.FollowedWorkoutRepository;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FollowedWorkoutService {

	private FollowedWorkoutRepository followedWorkoutRepository;

	public List<FollowedWorkout> getAllFollowedWorkouts() {
		return followedWorkoutRepository.findAll();
	}

	public Optional<FollowedWorkout> getFollowedWorkoutById(Long followId) {
		return followedWorkoutRepository.findById(followId);
	}

	public FollowedWorkout saveFollowedWorkout(FollowedWorkout followedWorkout) {
		// You can add validation or business logic before saving
		return followedWorkoutRepository.save(followedWorkout);
	}

	public void deleteFollowedWorkout(Long followId) {
		followedWorkoutRepository.deleteById(followId);
	}

	// Add other methods as needed
}
