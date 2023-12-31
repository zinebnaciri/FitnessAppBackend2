package com.example.demo.service;


import org.springframework.stereotype.Service;

import com.example.demo.entity.Measurement;
import com.example.demo.repository.MeasurementRepository;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MeasurementService {

	private MeasurementRepository measurementRepository;

	public List<Measurement> getAllMeasurements() {
		return measurementRepository.findAll();
	}

	public Optional<Measurement> getMeasurementById(Long measurementId) {
		return measurementRepository.findById(measurementId);
	}

	public Measurement saveMeasurement(Measurement measurement) {
		// You can add validation or business logic before saving
		return measurementRepository.save(measurement);
	}

	public void deleteMeasurement(Long measurementId) {
		measurementRepository.deleteById(measurementId);
	}

	// Add other methods as needed
}
