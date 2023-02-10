package com.example.demo.Modules;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

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
public class Clinic {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private String name;
	private String imagePath;
	@Column(nullable = false)
	private String address;
	private String email;
	private String contact;
	private double longitude;
	private double latitude;
	private String position;
//	@JsonFormat(pattern = "dd/MM/yyyy")
//	private LocalDate date;
//	@JsonFormat(pattern = "hh:mm:ss a")
//	private LocalTime openTime;
//	@JsonFormat(pattern = "hh:mm:ss a")
//	private LocalTime closeTime;
	@Column(nullable = false)
	private String vetEmail;
	
}
