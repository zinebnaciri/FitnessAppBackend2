package com.example.demo.entity;

import java.time.LocalDate;

import jakarta.persistence.*;

import lombok.Data;

@Entity
@Data
@Table(name = "measurements")
public class Measurement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long measurementId;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	private LocalDate date;
	private double weight;
	private double height;
	private double bodyFatPercentage;

}
