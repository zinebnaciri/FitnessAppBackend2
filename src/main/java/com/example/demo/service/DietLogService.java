package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.DietLog;
import com.example.demo.repository.DietLogRepository;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DietLogService {

	private DietLogRepository dietLogRepository;

	public List<DietLog> getAllDietLogs() {
		return dietLogRepository.findAll();
	}

	public Optional<DietLog> getDietLogById(Long logId) {
		return dietLogRepository.findById(logId);
	}

	public DietLog saveDietLog(DietLog dietLog) {
		// You can add validation or business logic before saving
		return dietLogRepository.save(dietLog);
	}

	public void deleteDietLog(Long logId) {
		dietLogRepository.deleteById(logId);
	}

	// Add other methods as needed
}
