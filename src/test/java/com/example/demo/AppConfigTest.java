package com.example.demo;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.AppConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AppConfigTest {

	@Mock
	private UserRepository userRepository;

	@InjectMocks
	private AppConfig appConfig;

	@Test
	void testUserDetailsServiceWithUserFound() {
		// Arrange
		String username = "testUser";

		when(userRepository.findByEmail(username)).thenReturn(Optional.of(createMockUser()));

		// Act and Assert
		assertDoesNotThrow(() -> appConfig.userDetailsService().loadUserByUsername(username));
	}

	@Test
	void testUserDetailsServiceWithUserNotFound() {
		// Arrange
		String username = "nonexistentUser";
		when(userRepository.findByEmail(username)).thenReturn(Optional.empty());

		// Act and Assert
		assertThrows(UsernameNotFoundException.class,
				() -> appConfig.userDetailsService().loadUserByUsername(username));
	}

	private User createMockUser() {

		return User.builder().userId(1L).firstName("John").lastName("Doe").username("testUser").password("password")
				.email("john.doe@example.com").dateOfBirth(LocalDate.of(1990, 1, 1)).gender("Male").height(175.0)
				.weight(70.0).goals(Collections.emptyList()).build();
	}
}
