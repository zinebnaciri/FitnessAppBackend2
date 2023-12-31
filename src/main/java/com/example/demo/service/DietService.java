package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Diet;
import com.example.demo.repository.DietRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DietService {

	private DietRepository dietRepository;

	public List<Diet> getAllDiets() {
		return dietRepository.findAll();
	}

	public Optional<Diet> getDietById(Long dietId) {
		return dietRepository.findById(dietId);
	}

	public Diet saveDiet(Diet diet) {
		// You can add validation or business logic before saving
		return dietRepository.save(diet);
	}

	public void deleteDiet(Long dietId) {
		dietRepository.deleteById(dietId);
	}

}
