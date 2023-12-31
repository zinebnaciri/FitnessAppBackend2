package com.example.demo.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.example.demo.entity.Workout;

public class WorkoutTest {

	@Test
	public void testGettersAndSetters() {

		Long workoutId = 1L;
		String name = "Cardio";
		String description = "Aerobic exercise";
		int duration = 30;
		String difficulty = "Intermediate";

		Workout workout = new Workout();
		workout.setWorkoutId(workoutId);
		workout.setName(name);
		workout.setDescription(description);
		workout.setDuration(duration);
		workout.setDifficulty(difficulty);

		assertEquals(workoutId, workout.getWorkoutId());
		assertEquals(name, workout.getName());
		assertEquals(description, workout.getDescription());
		assertEquals(duration, workout.getDuration());
		assertEquals(difficulty, workout.getDifficulty());
	}
}
