package com.example.demo.Servises;

import java.util.List;

import com.example.demo.Dto.BookingDto;
import com.example.demo.Modules.Booking;

public interface BookingService {
	
	Booking save(BookingDto data)throws Exception;
	List<Booking> getByClinicId(Long id);
	List<Booking> getByVetId(Long id);
	List<Booking> getByClinicIdAndVetId(Long clinicId, Long vetId);
	Booking updateAction(BookingDto data)throws Exception;
}
