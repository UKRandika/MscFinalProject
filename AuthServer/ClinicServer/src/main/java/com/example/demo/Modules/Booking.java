package com.example.demo.Modules;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Booking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate date;
	@JsonFormat(pattern = "hh:mm:ss a")
	private LocalTime time;
	@Column(nullable = false)
	private Long userId;
	@Column(nullable = false)
	private Long clinicId;
	@Column(nullable = false)
	private Long vetId;
	@Column(nullable = false)
	private Long petId;
	private boolean action;

}
