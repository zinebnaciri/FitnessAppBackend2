package com.example.demo.security;

import jakarta.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.LogoutHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	private LogoutHandler logoutHandler;

	public SecurityConfig(LogoutHandler logoutHandler) {
		this.logoutHandler = logoutHandler;
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().requestMatchers("/public-endpoint/**").permitAll()
				.requestMatchers("/api/auth/logout").authenticated()

				.and().logout().logoutUrl("/api/auth/logout").addLogoutHandler(logoutHandler)
				.logoutSuccessHandler((request, response, authentication) -> {
					SecurityContextHolder.clearContext();
					response.setStatus(HttpServletResponse.SC_OK);
				});

		return http.build();
	}

}
