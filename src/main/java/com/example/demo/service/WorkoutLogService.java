package com.example.demo.service;


import org.springframework.stereotype.Service;

import com.example.demo.entity.WorkoutLog;
import com.example.demo.repository.WorkoutLogRepository;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WorkoutLogService {

	
	private WorkoutLogRepository workoutLogRepository;

	public List<WorkoutLog> getAllWorkoutLogs() {
		return workoutLogRepository.findAll();
	}

	public Optional<WorkoutLog> getWorkoutLogById(Long logId) {
		return workoutLogRepository.findById(logId);
	}

	public WorkoutLog saveWorkoutLog(WorkoutLog workoutLog) {

		return workoutLogRepository.save(workoutLog);
	}

	public void deleteWorkoutLog(Long logId) {
		workoutLogRepository.deleteById(logId);
	}

}
