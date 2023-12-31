package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public Optional<User> getUserById(Long userId) {
		return userRepository.findById(userId);
	}

	public User saveUser(User user) {

		return userRepository.save(user);
	}

	public void deleteUser(Long userId) {
		userRepository.deleteById(userId);
	}

	public User updateUser(Long userId, User updatedUser) {

		User existingUser = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

		existingUser.setEmail(updatedUser.getEmail());
		existingUser.setDateOfBirth(updatedUser.getDateOfBirth());
		existingUser.setGender(updatedUser.getGender());
		existingUser.setHeight(updatedUser.getHeight());
		existingUser.setWeight(updatedUser.getWeight());

		return userRepository.save(existingUser);
	}
}
