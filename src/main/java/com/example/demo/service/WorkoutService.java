package com.example.demo.service;


import org.springframework.stereotype.Service;

import com.example.demo.entity.Workout;
import com.example.demo.repository.WorkoutRepository;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WorkoutService {

    private WorkoutRepository workoutRepository;

    public List<Workout> getAllWorkouts() {
        return workoutRepository.findAll();
    }

    public Optional<Workout> getWorkoutById(Long workoutId) {
        return workoutRepository.findById(workoutId);
    }

    public Workout saveWorkout(Workout workout) {
        
        return workoutRepository.save(workout);
    }

    public void deleteWorkout(Long workoutId) {
        workoutRepository.deleteById(workoutId);
    }

 
}
