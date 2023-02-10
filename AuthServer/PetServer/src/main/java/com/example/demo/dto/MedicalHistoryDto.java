package com.example.demo.dto;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.demo.Modules.PetDetails;

import lombok.Builder;
import lombok.Data;

@Data
public class MedicalHistoryDto {
	private String content;
	private String petId;
	private Long vetId;
	private Long clinicId;
	private String symptoms;
	private String medication;
	private Double weight;
	private Double age;
}
