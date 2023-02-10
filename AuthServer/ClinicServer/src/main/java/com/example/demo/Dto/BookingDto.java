package com.example.demo.Dto;

import java.time.LocalDate;
import java.time.LocalTime;



import lombok.Data;

@Data
public class BookingDto {
	
	private LocalDate date;
	private LocalTime time;
	private Long userId;
	private Long clinicId;
	private Long vetId;
	private boolean action;
	
	public BookingDto() {
		super();
	}

	public BookingDto(LocalDate date, LocalTime time, Long userId, Long clinicId, Long vetId, boolean action) {
		super();
		this.date = date;
		this.time = time;
		this.userId = userId;
		this.clinicId = clinicId;
		this.vetId = vetId;
		this.action = action;
	}
	
	
	
}
